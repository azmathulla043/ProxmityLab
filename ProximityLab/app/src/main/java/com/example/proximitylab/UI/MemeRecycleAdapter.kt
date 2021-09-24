package com.example.proximitylab.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proximitylab.Model.Meme
import com.example.proximitylab.R

class MemeRecycleAdapter(var MemesList: ArrayList<Meme>?, var itemClick: hospitalClickListener) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    override fun getItemCount(): Int {
        return MemesList!!.size
    }

    interface hospitalClickListener {
        fun getItem(position: Int)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bindData(MemesList, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerViewHolder.RecycleViewHolder {
        var view: View = LayoutInflater.from(parent!!.context).inflate(R.layout.meme, parent, false)
        return RecyclerViewHolder(view, itemClick)
    }

    class RecyclerViewHolder(itemView: View, var itemClick: hospitalClickListener) : RecyclerView.ViewHolder(itemView) {
        //    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textName: TextView = itemView.findViewById(R.id.text_name)
    }
}