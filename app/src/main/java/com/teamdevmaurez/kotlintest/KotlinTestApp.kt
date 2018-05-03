package com.teamdevmaurez.kotlintest

import android.app.Activity
import android.app.Application
import android.os.StrictMode
import android.util.Log
import com.facebook.stetho.Stetho
import com.teamdevmaurez.kotlintest.dependencyinjection.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by teamdevmaurez on 22/03/2018.
 */
class KotlinTestApp : Application(), HasActivityInjector {

    @Inject
    lateinit internal var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = activityDispatchingAndroidInjector


    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
                     Timber.plant(Timber.DebugTree())
/*
                    StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                             .detectDiskReads()
                             .detectDiskWrites()
                             .detectNetwork()   // or .detectAll() for all detectable problems
                             .penaltyLog() // Log detected violations to the system log.
                             .build())

                     StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                             .detectLeakedSqlLiteObjects()
                             .detectLeakedClosableObjects()
                             .penaltyLog()
                             .penaltyDeath() // Crashes the whole process on violation.
                             .build())


                     Stetho.initializeWithDefaults(this);*/
        } else {
            Timber.plant(CrashReportingTree())
        }

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)

        Timber.d("Application create")

    }


    /** A tree which logs important information for crash reporting.  */
    private class CrashReportingTree : Timber.Tree() {

        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {

            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }

//            CrashLibrary.log(priority, tag, message)
//
//            if (t != null) {
//                if (priority == Log.ERROR) {
//                    CrashLibrary.logError(t)
//                } else if (priority == Log.WARN) {
//                    CrashLibrary.logWarning(t)
//                }
//            }
        }
    }
}