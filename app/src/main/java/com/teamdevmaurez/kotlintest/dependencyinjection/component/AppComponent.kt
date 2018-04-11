package com.teamdevmaurez.kotlintest.dependencyinjection

import android.app.Application
import com.teamdevmaurez.kotlintest.KotlinTestApp
import com.teamdevmaurez.kotlintest.dependencyinjection.builder.ActivityBuilder
import com.teamdevmaurez.kotlintest.dependencyinjection.module.AppModule
import com.teamdevmaurez.kotlintest.dependencyinjection.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(AndroidInjectionModule::class),
    (AndroidSupportInjectionModule::class),
    (AppModule::class),
    (NetworkModule::class),
    (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: KotlinTestApp)

}