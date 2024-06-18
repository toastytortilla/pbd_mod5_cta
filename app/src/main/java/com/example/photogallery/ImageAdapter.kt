package com.example.photogallery

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageAdapter(private val context: Context, private val images: List<ImageItem>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = images[position]

        // Use Glide to load the image
        Glide.with(holder.itemView.context)
            .load(image.uri)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .into(holder.imageView)

        // Handel click on item
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ImageViewerActivity::class.java)
            intent.putExtra("IMAGE_URL", image.uri)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }
}
