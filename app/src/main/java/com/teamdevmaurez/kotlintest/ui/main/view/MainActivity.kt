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

        presenter.onAttach(this)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        openMangaGalleryFragment()
    }

    override fun openMangaGalleryFragment() {
        Timber.d("openMangaGalleryFragment()")

        // lockDrawer()
        supportFragmentManager.addFragment(R.id.fragment_Content, MangasFragment.newInstance(), MangasFragment.TAG)
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

    override fun onFragmentAttached() {
        Timber.d("onFragmentAttached()")
    }

    override fun onFragmentDetached(tag: String) {
        Timber.d("onFragmentDetached()")

        supportFragmentManager?.removeFragment(tag = tag)
    }

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_old)

        val initialTextviewtranslationY = TextView_progress.translationY

        seekBar2.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                TextView_progress.text = progress.toString()

                val translationDistance = (initialTextviewtranslationY + progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                TextView_progress.animate().translationY(translationDistance)

                //if(!fromUser) {
                    //TextView_progress.animate().setDuration(500).rotationBy(360f).translationY(initialTextviewtranslationY)
                //}

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

        button_reset.setOnClickListener(){
            seekBar2.progress = 0

            beginSearch()
        }

    }



    private var disposable: Disposable? = null

    private val mangaScraperServ by lazy {
        MangaScraperApi.create()
    }

    private fun beginSearch() {
        //imageView2.animate().setInterpolator {  }setInterpolator()setDuration(5500).rotationBy(360f)

        disposable = mangaScraperServ.getChapter("mangareader.net", "naruto", 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> textView_name.text = "Name of manga: ${result.name} " },
                        { error -> Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show() }
                )
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    */
}
