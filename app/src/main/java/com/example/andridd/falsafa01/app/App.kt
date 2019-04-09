package com.example.android.tour01.app

import android.app.Application
import com.example.android.tour01.database.Database

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Database.init(this)
    }
}