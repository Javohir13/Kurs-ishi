package com.example.android.tour01.fragments

import android.webkit.WebView
import com.example.andridd.tour01.R

class ShowThemeFragment : BaseFragment(R.layout.show_theme_fragment) {

    override fun onViewCreate() {
        var webView: WebView = myView!!.findViewById(R.id.my_web_view)
//        Toast.makeText(activity, "${viewModel.idTheme}", Toast.LENGTH_LONG).show()
        val mavzu = viewModel.mavzuModel
        webView.loadUrl("file:///android_asset/html/word${mavzu.id_bob}${mavzu.id}.htm")
    }
}