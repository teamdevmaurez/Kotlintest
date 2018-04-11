package com.teamdevmaurez.kotlintest.dependencyinjection.module

import android.app.Application
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.teamdevmaurez.kotlintest.BuildConfig
import com.teamdevmaurez.kotlintest.data.network.NetworkConstants.CACHE_SIZE
import com.teamdevmaurez.kotlintest.data.network.retrofit.MangaScraperApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Module which provides all required dependencies about network
 */
@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object NetworkModule {


    @Provides
    @Reusable
    @JvmStatic
    internal fun provideHttpCache(application: Application): Cache {
        return Cache(application.getCacheDir(), CACHE_SIZE)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideOkHttpClient(cache:Cache): OkHttpClient {
        return OkHttpClient().newBuilder()
                .cache(cache)
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                })
                .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    fun providesMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {

        return Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(BuildConfig.BASE_URL)
                .build()
    }

    /**
     * Provides the Post service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the Post service implementation.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideMangaScraperApi(retrofit: Retrofit): MangaScraperApi {
        return retrofit.create(MangaScraperApi::class.java)
    }
}