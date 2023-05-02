package com.example.mygallery

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class PhotoAdapter(private var images: ArrayList<String>) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.slider_photo)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoAdapter.PhotoViewHolder {
        return PhotoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PhotoAdapter.PhotoViewHolder, position: Int) {
        holder.itemImage.setImageURI(Uri.parse(images[position]))
    }

    override fun getItemCount(): Int {
        return images.size
    }
}