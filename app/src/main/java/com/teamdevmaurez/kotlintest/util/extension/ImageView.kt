package com.mindorks.framework.mvp.util.extension

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.teamdevmaurez.kotlintest.R
import com.teamdevmaurez.kotlintest.dependencyinjection.module.GlideApp
import timber.log.Timber


internal fun ImageView.loadImage(url: String, progressBar: ProgressBar) {

    val requestOptions = RequestOptions()
            .centerCrop()
            .error(R.drawable.item_manga_default_image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)

    GlideApp.with(this.context)
            .load(url)
            .apply(requestOptions)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(p0: GlideException?, p1: Any?, p2: Target<Drawable>?, p3: Boolean): Boolean {
                    Timber.e(p0, "onLoadFailed")

                    progressBar.setVisibility(View.GONE)
                    return false
                }

                override fun onResourceReady(p0: Drawable?, p1: Any?, p2: Target<Drawable>?, p3: DataSource?, p4: Boolean): Boolean {
                    //Timber.d("OnResourceReady %s", if (p1 is String) p1 else "")

                    progressBar.setVisibility(View.GONE)
                    return false
                }
            })
            .into(this)
}
