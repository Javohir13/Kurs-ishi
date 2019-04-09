package com.example.andridd.tour01.UI

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.andridd.tour01.R
import com.example.android.tour01.fragments.MainFragment
import com.example.android.tour01.viewmodels.FragmentViewModel
import kotlinx.android.synthetic.main.activity_scrolling.*

class ScrollingActivity : AppCompatActivity() {

    lateinit var viewModel: FragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            back(view)
        }

        viewModel = ViewModelProviders.of(this).get(FragmentViewModel::class.java)

        viewModel.apply {
            layoutId = R.id.my_fragment_main
            meneger = supportFragmentManager
            startFergment(MainFragment::class.java)
        }
    }

    var k = 0
    fun back(view: View) {
        k = 1
        if (viewModel.stack.size > 1) {
            viewModel.stack.pop()
            viewModel.startFergment(viewModel.fragments[viewModel.stack.peek()]!!.javaClass)
            viewModel.stack.pop()
        } else if (viewModel.stack.size == 1) {
            Snackbar.make(view, "Chiqish?", Snackbar.LENGTH_LONG)
                .setAction("Ok") {
                    onBackPressed()
                }.show()
        }
    }

    override fun onBackPressed() {
        if (k == 1) {
            super.onBackPressed()
            k = 0
        } else {
            if (viewModel.stack.size > 1) {
                viewModel.stack.pop()
                viewModel.startFergment(viewModel.fragments[viewModel.stack.peek()]!!.javaClass)
                viewModel.stack.pop()
            } else if (viewModel.stack.size == 1) {
                super.onBackPressed()
            }
        }
    }
}
