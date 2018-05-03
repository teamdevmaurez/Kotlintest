package com.teamdevmaurez.kotlintest.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.teamdevmaurez.kotlintest.ui.main.view.MainActivity
import timber.log.Timber


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        Timber.d("onCreate")

        // Start home activity

        startActivity(Intent(this@SplashActivity, MainActivity::class.java))

        // close splash activity

        finish()

    }

    override fun onDestroy() {
        Timber.d("onDestroy")

        super.onDestroy()
    }

}