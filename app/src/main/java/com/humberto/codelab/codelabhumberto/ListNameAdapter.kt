package com.humberto.codelab.codelabhumberto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_names_row.view.*

class ListNameAdapter(val onClick: (pair: Pair<String, String>) -> Unit) : RecyclerView.Adapter<ListNameAdapter.ViewHolder>() {

    var namesList = mutableListOf<Pair<String, String>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_names_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = namesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(namesList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(pair: Pair<String, String>) {

            with(itemView) {
                list_names_name.text = pair.first
                list_names_age.text = pair.second

                list_names_name.setOnClickListener {
                    onClick(pair)
                }

                list_names_age.setOnClickListener {
                    list_names_name.callOnClick()
                }


            }




        }

    }


}