package com.example.android.tour01.ServisControl

import android.database.Cursor
import com.example.android.tour01.models.MavzuModel
import com.example.android.tour01.models.ThemeModel

class Controller {
    companion object {
        fun getAllTheme(cursor: Cursor): ArrayList<ThemeModel> {
            var data = ArrayList<ThemeModel>()
//        Mas.show("getBob " + cursor.count)

            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                data.add(
                    ThemeModel(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("title")),
                        cursor.getString(cursor.getColumnIndex("massage")),
                        cursor.getInt(cursor.getColumnIndex("id_bob"))
                    )
                )
                cursor.moveToNext()
            }
            return data
        }

        fun getAllMavzu(cursor: Cursor): ArrayList<MavzuModel> {
            var data = ArrayList<MavzuModel>()
//            Mas.show("getBob " + cursor.count)

            var k = 1
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                data.add(
                    MavzuModel(
                        k,
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("title")),
                        cursor.getString(cursor.getColumnIndex("massage")),
                        cursor.getInt(cursor.getColumnIndex("id_bob"))
                    )
                )
                k++
                cursor.moveToNext()
            }
            return data
        }
    }

}