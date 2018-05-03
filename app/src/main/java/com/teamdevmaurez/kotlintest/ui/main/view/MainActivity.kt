package com.teamdevmaurez.kotlintest.ui.main.view

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import com.teamdevmaurez.kotlintest.R
import com.teamdevmaurez.kotlintest.ui.base.view.BaseActivity
import com.teamdevmaurez.kotlintest.ui.main.interactor.MainMVPInteractor
import com.teamdevmaurez.kotlintest.ui.main.presenter.MainMVPPresenter
import com.teamdevmaurez.kotlintest.ui.mangaslist.view.MangasFragment
import com.teamdevmaurez.kotlintest.util.extension.addFragment
import com.teamdevmaurez.kotlintest.util.extension.removeFragment
import com.teamdevmaurez.kotlintest.util.extension.replaceFragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_navigation.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMVPView, NavigationView.OnNavigationItemSelectedListener, HasSupportFragmentInjector {

    @Inject
    internal lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = fragmentDispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("onCreate()")

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            Timber.d("add MangasFragment")
            supportFragmentManager.replaceFragment(R.id.fragment_Content, MangasFragment.newInstance(), MangasFragment.TAG)
        }

        presenter.onAttach(this)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }



    override fun onBackPressed() {
        Timber.d("onBackPressed()")

        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        Timber.d("onCreateOptionsMenu()")

        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Timber.d("onOptionsItemSelected()")

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Timber.d("onNavigationItemSelected()")

        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_gallery -> {
                presenter.onDrawerMangasGalleryClick()
            }
            R.id.nav_slideshow -> {
                supportFragmentManager.addFragment(R.id.fragment_Content, MangasFragment.newInstance(), MangasFragment.TAG)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onFragmentAttached(tag: String?) {
        Timber.d("onFragmentAttached() : %s", tag)
    }

    override fun onFragmentDetached(tag: String) {
        Timber.d("onFragmentDetached() : %s", tag)

        supportFragmentManager?.removeFragment(tag = tag)
    }



    override fun openMangaGalleryFragment() {
        Timber.d("openMangaGalleryFragment()")

        // lockDrawer()
        supportFragmentManager.replaceFragment(R.id.fragment_Content, MangasFragment.newInstance(), MangasFragment.TAG)
    }


}
