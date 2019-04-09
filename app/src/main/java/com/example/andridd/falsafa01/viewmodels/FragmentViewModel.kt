package com.example.android.tour01.viewmodels

import android.arch.lifecycle.ViewModel
import android.support.v4.app.FragmentManager
import com.example.android.tour01.fragments.BaseFragment
import com.example.android.tour01.models.MavzuModel
import java.util.*

class FragmentViewModel : ViewModel() {

    var fragments = HashMap<String, BaseFragment>()
    var stack = Stack<String>()
    lateinit var meneger: FragmentManager
    var layoutId: Int = 0

    var idTheme = 0
    lateinit var mavzuModel: MavzuModel

    fun <T : BaseFragment> startFergment(fragment: Class<T>) {
        stack.push(fragment.name)
        meneger.beginTransaction().replace(layoutId, getFerment(fragment)).commitNow()
    }

    private fun <T : BaseFragment> getFerment(fragment: Class<T>): BaseFragment {
        if (!fragments.containsKey(fragment.name)) {
            fragments.put(fragment.name, fragment.newInstance())
        }
        return fragments.get(fragment.name)!!
    }
}