package com.yoesuv.mvpnetworking.menu.gallery.adapters

import android.app.Activity
import android.support.annotation.NonNull
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.yoesuv.mvpnetworking.R
import com.yoesuv.mvpnetworking.menu.gallery.models.GalleryModel
import kotlinx.android.synthetic.main.item_gallery.view.*

/**
 *  Created by yusuf on 4/18/18.
 */
class GalleryAdapter(activity: Activity, private var listGallery:MutableList<GalleryModel.Gallery>): RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    private val inflater:LayoutInflater = LayoutInflater.from(activity.applicationContext)

    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val view:View = inflater.inflate(R.layout.item_gallery, parent, false)
        return GalleryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listGallery.size
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.setData(listGallery[holder.adapterPosition])
    }

    class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(gallery: GalleryModel.Gallery){
            Glide.with(itemView.context)
                    .load(gallery.thumbnail)
                    .apply(RequestOptions()
                            .format(DecodeFormat.PREFER_ARGB_8888)
                            .placeholder(R.drawable.image_placeholder)
                            .error(R.drawable.image_placeholder))
                    .into(itemView.imageViewItemGallery)
        }
    }
}