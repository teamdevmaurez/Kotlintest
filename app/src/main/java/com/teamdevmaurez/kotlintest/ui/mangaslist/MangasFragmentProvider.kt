package com.teamdevmaurez.kotlintest.ui.mangaslist

import com.teamdevmaurez.kotlintest.ui.mangaslist.view.MangasFragment
import com.teamdevmaurez.kotlintest.ui.mangaslist.view.TestFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by teamdevmaurez on 05/04/2018.
 */
@Module
internal abstract class MangasFragmentProvider {

    @ContributesAndroidInjector(modules = [MangasFragmentModule::class])
    internal abstract fun provideMangasFragmentFactory(): MangasFragment

    @ContributesAndroidInjector(modules = [MangasFragmentModule::class])
    internal abstract fun provideTestFragmentFactory(): TestFragment
}