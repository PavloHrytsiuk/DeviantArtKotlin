package org.hrytsiuk.deviantart.deviantartkotlin.core.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.hrytsiuk.deviantart.deviantartkotlin.R
import org.hrytsiuk.deviantart.deviantartkotlin.base.OnItemClickListener
import org.hrytsiuk.deviantart.deviantartkotlin.core.model.Picture

class PictureAdapter(private val pictures: List<Picture>, private val listener: OnItemClickListener) : RecyclerView.Adapter<PictureAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_picture, parent, false), listener)
    }

    override fun getItemCount(): Int {
        return pictures.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.picureTitle.text = pictures[position].title
        Picasso.with(holder.itemView.context).load(pictures[position].content.src).into(holder.pictureImage)
    }


    class ViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val pictureCard: CardView = itemView.findViewById(R.id.pictureCard)
        val picureTitle: TextView = itemView.findViewById(R.id.pictureTitle)
        val pictureImage: ImageView = itemView.findViewById(R.id.pictureImage)

        init {
            pictureCard.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}