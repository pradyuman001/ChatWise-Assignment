package com.example.chatwisedemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chatwisedemo.R
import com.example.chatwisedemo.activity.ImageViewActivity
import com.example.chatwisedemo.model.ChatWiseModelItem

class ImageViewAdapter(
    private val activity: ImageViewActivity,
    private val mainList: ArrayList<ChatWiseModelItem>
) : RecyclerView.Adapter<ImageViewAdapter.ViewData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
       val viewData = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image_view_activity, parent, false)
        return ViewData(viewData)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        Glide.with(activity).load(mainList[position].url).into(holder.image)
    }
    override fun getItemCount(): Int {
        return mainList.size
    }

    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView = itemView.findViewById(R.id.item_image_view_activity_image_view)

    }

}