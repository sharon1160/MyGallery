package com.example.mygallery

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.mygallery.fragments.GalleryFragment.Companion.selectedImagesList

class GridItemAdapter(val images: Array<String>): RecyclerView.Adapter<GridItemAdapter.ViewHolder> () {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image :  ImageView = itemView.findViewById(R.id.photo)
        val selected: View = itemView.findViewById(R.id.selectedView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.image.setImageURI(Uri.parse(images[position]))

        if(!selectedImagesList.contains(images[position])){
            holder.selected.visibility = View.GONE
        } else {
            holder.selected.visibility = View.VISIBLE
        }

        holder.image.setOnClickListener {
            if (!selectedImagesList.contains(images[position])) {
                selectedImagesList.add(images[position])
                holder.selected.visibility = View.VISIBLE
            } else {
                holder.selected.visibility = View.GONE
                selectedImagesList.remove(images[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }
}
