package com.teamdevmaurez.kotlintest.util.extension

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.teamdevmaurez.kotlintest.R
import timber.log.Timber


internal fun FragmentManager.removeFragment(tag: String,
                                            slideIn: Int = R.anim.slide_left,
                                            slideOut: Int = R.anim.slide_right) {
    Timber.d("Remove Fragment %s", tag)

    this.beginTransaction()
            .disallowAddToBackStack()
            //.setCustomAnimations(slideIn, slideOut)
            .remove(this.findFragmentByTag(tag))
            .commitNow()
}

internal fun FragmentManager.addFragment(containerViewId: Int,
                                         fragment: Fragment,
                                         tag: String,
                                         slideIn: Int = R.anim.slide_left,
                                         slideOut: Int = R.anim.slide_right) {
    Timber.d("Add Fragment %s", tag)

    this.beginTransaction()
            //.disallowAddToBackStack()
            //.setCustomAnimations(slideIn, slideOut)
            .add(containerViewId, fragment, tag)
            .commit()
}

internal fun FragmentManager.replaceFragment(containerViewId: Int,
                                             fragment: Fragment,
                                             tag: String,
                                             slideIn: Int = R.anim.slide_left,
                                             slideOut: Int = R.anim.slide_right) {
    Timber.d("Add Fragment %s", tag)

    this.beginTransaction()
            //.disallowAddToBackStack()
            //.setCustomAnimations(slideIn, slideOut)
            .replace(containerViewId, fragment, tag)
            .commit()
}

