package com.indigo.first_ui_project

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(var items: List<Item>, var context: Context) : RecyclerView.Adapter<MyViewHolder>() {
}

class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

}