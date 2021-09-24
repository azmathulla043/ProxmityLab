package com.example.proximitylab.UI

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proximitylab.Model.Meme
import com.example.proximitylab.R
import kotlinx.android.synthetic.main.meme.view.*

class MeamsAdapter(val Memes :MutableList<Meme> = mutableListOf()) :
    RecyclerView.Adapter<MeamsAdapter.memesViewHolder>() {
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): memesViewHolder {
        context = parent.context
        return memesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.meme,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: memesViewHolder, position: Int) {
        holder.bind(Memes[position])
    }

    override fun getItemCount(): Int = Memes.size


    inner class memesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = Memes.get(adapterPosition)
        fun bind(meme: memes) {
            val image = Memes.get(adapterPosition)
            Glide.with(context!!)
                .load(image.url)
                .fitCenter()
                .into(itemView.imageView)
        }
    }
}
