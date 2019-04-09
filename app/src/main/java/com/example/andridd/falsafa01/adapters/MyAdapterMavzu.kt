package com.example.android.tour01.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.andridd.tour01.R
import com.example.android.tour01.models.ThemeModel


class MyAdapterMavzu(var list: ArrayList<ThemeModel>, var listener: (myBob: ThemeModel) -> Unit) :
    RecyclerView.Adapter<MyAdapterMavzu.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false), listener
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(list[position])
    }


    class MyHolder(itemView: View, var listener: (myBob: ThemeModel) -> Unit) : RecyclerView.ViewHolder(itemView) {
        var v = itemView


        fun bind(data: ThemeModel) {
            var textBob: TextView = v.findViewById(R.id.text_item_main)
            var textTitl: TextView = v.findViewById(R.id.text_item_main_title)
            var textMassage: TextView = v.findViewById(R.id.text_item_main_massage)

            textBob.text = "${data.id}-Мавзу"
            textTitl.text = data.title
            textMassage.text = data.text

            v.setOnClickListener {
                listener(data)
            }
        }
    }
}