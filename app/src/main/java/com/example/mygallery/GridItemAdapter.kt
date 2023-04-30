package com.example.mygallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class GridItemAdapter(val images: Array<String>): RecyclerView.Adapter<GridItemAdapter.ViewHolder> () {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image :  ImageView = itemView.findViewById(R.id.photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(images[position]).into(holder.image)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}
