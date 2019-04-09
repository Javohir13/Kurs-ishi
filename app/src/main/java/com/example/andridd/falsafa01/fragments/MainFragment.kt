package com.example.android.tour01.fragments

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.andridd.tour01.R
import com.example.android.tour01.adapters.MyAdapterMavzuTwo
import com.example.android.tour01.database.Database

class MainFragment : BaseFragment(R.layout.main_fragment) {
    override fun onViewCreate() {
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        var adapter = MyAdapterMavzuTwo(Database.getInstance()!!.gatAllMavzu()) {

            viewModel.mavzuModel = it
            startFragment(ShowThemeFragment::class.java)
//            Toast.makeText(activity, "${it.id}", Toast.LENGTH_LONG).show()
        }

        var recycler = activity!!.findViewById<RecyclerView>(R.id.recycler_view_main)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = adapter
    }
}