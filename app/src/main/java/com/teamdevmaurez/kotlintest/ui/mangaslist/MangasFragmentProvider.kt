package com.teamdevmaurez.kotlintest.ui.mangaslist

import com.teamdevmaurez.kotlintest.ui.mangaslist.view.MangasFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class MangasFragmentProvider {

    @ContributesAndroidInjector(modules = [MangasFragmentModule::class])
    internal abstract fun provideMangasFragmentFactory(): MangasFragment
}