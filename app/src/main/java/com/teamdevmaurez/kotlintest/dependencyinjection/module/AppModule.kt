package com.teamdevmaurez.kotlintest.dependencyinjection.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.teamdevmaurez.kotlintest.data.database.AppDatabase
import com.teamdevmaurez.kotlintest.data.network.retrofit.MangaScraperApi
import com.teamdevmaurez.kotlintest.data.repository.MangaRepository
import com.teamdevmaurez.kotlintest.data.repository.MangaRepositoryHelper
import com.teamdevmaurez.kotlintest.util.AppConstants
import com.teamdevmaurez.kotlintest.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME).build()

    @Provides
    @Singleton
    internal fun provideMangasRepositoryHelper(appDatabase: AppDatabase, mangaScraperApi: MangaScraperApi): MangaRepositoryHelper {
        return MangaRepository(mangaScraperApi, appDatabase.mangasDao())
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

//    @Provides
//    @ApiKeyInfo
//    internal fun provideApiKey(): String = BuildConfig.API_KEY

//    @Provides
//    @PreferenceInfo
//    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

//    @Provides
//    @Singleton
//    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper


}