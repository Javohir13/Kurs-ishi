package com.example.android.tour01.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import com.example.android.tour01.viewmodels.FragmentViewModel
import com.labo.kaji.fragmentanimations.MoveAnimation

abstract class BaseFragment(@LayoutRes var layout: Int) : Fragment() {

    lateinit var viewModel: FragmentViewModel
    lateinit var myView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(layout, container, false)
        viewModel = ViewModelProviders.of(activity!!).get(FragmentViewModel::class.java)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreate()

    }

    abstract fun onViewCreate()

    fun <T : BaseFragment> startFragment(fragment: Class<T>) {
        viewModel.startFergment(fragment)
    }

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation {
        return if (enter) {
            MoveAnimation.create(MoveAnimation.LEFT, enter, 500)
        } else {
            MoveAnimation.create(MoveAnimation.LEFT, enter, 500)
        }
    }

}

