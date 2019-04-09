package com.example.android.tour01.database

import android.content.Context
import com.example.andridd.tour01.library.DBHelper
import com.example.android.tour01.ServisControl.Controller
import com.example.android.tour01.models.MavzuModel

class Database : DBHelper {
    var context: Context;

    private constructor(context: Context) : super(context, "iqtisod.db") {
        this.context = context
    }

    companion object {
        private var database: Database? = null

        fun init(context: Context) {
            if (database == null) {
                //Mas.show("database init")
                database = Database(context)
            }
        }

        fun getInstance(): Database? {
            return database
        }
    }

//    fun gatAllThem(): ArrayList<ThemeModel> {
////        Mas.show("getAllData()")
//        var cursor = mdatabase.rawQuery("select * from mavzu", null)
//        var data = Controller.getAllTheme(cursor).filter { it.id <= 12 } as ArrayList<ThemeModel>
//        return data
//    }

    fun gatAllMavzu(): ArrayList<MavzuModel> {
//        Mas.show("getAllData()")
        var cursor = mdatabase.rawQuery("select * from mavzu", null)
        var data = Controller.getAllMavzu(cursor)//.filter { it.id <= 12 } as ArrayList<MavzuModel>
        return data
    }
}
