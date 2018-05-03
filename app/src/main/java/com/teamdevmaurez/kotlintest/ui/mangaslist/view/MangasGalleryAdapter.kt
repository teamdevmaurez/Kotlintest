package com.teamdevmaurez.kotlintest.ui.mangaslist.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mindorks.framework.mvp.util.extension.loadImage
import com.teamdevmaurez.kotlintest.R
import com.teamdevmaurez.kotlintest.data.database.mangas.MangaEntity
import kotlinx.android.synthetic.main.item_manga_list.view.*
import timber.log.Timber


class MangasGalleryAdapter(private val mangaListItems: MutableList<MangaEntity>) : RecyclerView.Adapter<MangasGalleryAdapter.MangaViewHolder>() {

    override fun getItemCount() = this.mangaListItems.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MangaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_manga_list, parent, false))

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }


    internal fun addMangasToList(mangas: List<MangaEntity>) {
        Timber.d("addMangasToList size %d", mangas?.size)

        this.mangaListItems.addAll(mangas)

        Timber.d("addMangasToList notifyDataSetChanged")
        notifyDataSetChanged()
    }

    inner class MangaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.coverImageView.setImageDrawable(null)
            itemView.titleTextView.text = ""
        }

        fun onBind(position: Int) {
            val title = mangaListItems[position].name
            val coverUrl = mangaListItems[position].cover

            inflateData(title, coverUrl)
        }

        private fun inflateData(title: String?, coverUrl: String?) {
            title?.let { itemView.titleTextView.text = it }
            coverUrl?.let {
                itemView.coverImageView.loadImage(it, itemView.progress_loading_cover)
            }
        }

    }
}
