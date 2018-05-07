package com.teamdevmaurez.kotlintest.ui.mangaslist.view

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teamdevmaurez.kotlintest.R
import com.teamdevmaurez.kotlintest.data.database.mangas.MangaEntity
import com.teamdevmaurez.kotlintest.ui.base.view.BaseFragment
import com.teamdevmaurez.kotlintest.ui.mangaslist.interactor.MangasMVPInteractor
import com.teamdevmaurez.kotlintest.ui.mangaslist.presenter.MangasMVPPresenter
import com.teamdevmaurez.kotlintest.util.DeviceUtils
import com.teamdevmaurez.kotlintest.util.PreCachingLayoutManager
import kotlinx.android.synthetic.main.fragment_gallery_mangas.*
import timber.log.Timber
import javax.inject.Inject


class MangasFragment : BaseFragment(), MangasMVPView {

    companion object {

        const val TAG = "MangasFragment"

        fun newInstance(): MangasFragment {
            return MangasFragment()
        }
    }

    @Inject
    internal lateinit var mangasGalleryAdapter: MangasGalleryAdapter

    @Inject
    internal lateinit var layoutManager: PreCachingLayoutManager

    @Inject
    internal lateinit var presenter: MangasMVPPresenter<MangasMVPView, MangasMVPInteractor>


    /************* Fragment IMPL **************/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Timber.d("onCreateView")

        return inflater.inflate(R.layout.fragment_gallery_mangas, container, false)
    }

    override fun onDestroyView() {
        presenter.onDetach()

        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    /************* BaseFragment IMPL **************/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.d("onViewCreated")

        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {
        Timber.d("setUp")

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.setExtraLayoutSpace(DeviceUtils.getScreenHeight(this.activity!!))

        gallery_manga_recycler_view.layoutManager = layoutManager
        gallery_manga_recycler_view.itemAnimator = DefaultItemAnimator()
        gallery_manga_recycler_view.adapter = mangasGalleryAdapter

        presenter.onViewPrepared()
    }


    /************* BaseFragment IMPL **************/

    override fun displayMangaList(mangas: List<MangaEntity>?) {
        mangas?.let {
            Timber.d("displayMangaList")

            if (!it.isEmpty()) {

                hideEmptylist()

                mangasGalleryAdapter.addMangasToList(it)
            }

            if (mangasGalleryAdapter.itemCount == 0) {
                showEmptylist()
            }
        }
    }

    override fun hideEmptylist() {
        Timber.d("hideEmptylist")

        textView_empty_list.visibility = View.GONE
        gallery_manga_recycler_view.visibility = View.VISIBLE
    }

    override fun showEmptylist() {
        Timber.d("showEmptylist")

        textView_empty_list.visibility = View.VISIBLE
        gallery_manga_recycler_view.visibility = View.GONE
    }


}