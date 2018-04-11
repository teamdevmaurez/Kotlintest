package com.teamdevmaurez.kotlintest.dependencyinjection.builder


import com.teamdevmaurez.kotlintest.ui.main.MainActivityModule
import com.teamdevmaurez.kotlintest.ui.main.view.MainActivity
import com.teamdevmaurez.kotlintest.ui.mangaslist.MangasFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (MangasFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity

}