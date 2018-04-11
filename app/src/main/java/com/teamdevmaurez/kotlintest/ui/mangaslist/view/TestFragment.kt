package com.teamdevmaurez.kotlintest.ui.mangaslist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teamdevmaurez.kotlintest.R
import com.teamdevmaurez.kotlintest.ui.base.view.BaseFragment

class TestFragment : BaseFragment() {


    companion object {

        internal val TAG = "TestFragment"

        fun newInstance(): TestFragment {
            return TestFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.test_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {

    }

}