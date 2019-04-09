package com.example.andridd.tour01

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import com.example.andridd.tour01.UI.ScrollingActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_main1.animation = AnimationUtils.loadAnimation(this, R.anim.main_anim_alpha)
//        text_main2.animation = AnimationUtils.loadAnimation(this, R.anim.main_anim_alpha)
        text_main3.animation = AnimationUtils.loadAnimation(this, R.anim.anim_botton_com)
        image_cam.animation = AnimationUtils.loadAnimation(this, R.anim.main_anim_alpha)

        Handler().postDelayed({
            var intent = Intent(this, ScrollingActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
