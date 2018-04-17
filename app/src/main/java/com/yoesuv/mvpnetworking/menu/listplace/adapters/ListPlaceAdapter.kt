package com.yoesuv.mvpnetworking.menu.listplace.adapters

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.yoesuv.mvpnetworking.R
import com.yoesuv.mvpnetworking.datas.Constants
import com.yoesuv.mvpnetworking.menu.listplace.models.ListPlaceModel
import kotlinx.android.synthetic.main.item_list_place.view.*

/**
 *  Created by yusuf on 4/17/18.
 */
class ListPlaceAdapter(activity: Activity, private val listPlace: MutableList<ListPlaceModel.Place>): RecyclerView.Adapter<ListPlaceAdapter.ListPlaceViewHolder>() {

    private var inflater: LayoutInflater = LayoutInflater.from(activity.applicationContext)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListPlaceViewHolder {
        val view:View = inflater.inflate(R.layout.item_list_place, parent, false)
        return ListPlaceViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d(Constants.RESULT_DEBUG,"ListPlaceAdapter # data size ${listPlace.size}")
        return listPlace.size
    }

    override fun onBindViewHolder(holder: ListPlaceViewHolder?, position: Int) {
        holder?.setData(listPlace[holder.adapterPosition])
    }

    fun addData(listPlace: MutableList<ListPlaceModel.Place>){
        this.listPlace.addAll(listPlace)
    }

    class ListPlaceViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun setData(place: ListPlaceModel.Place){
            itemView.textViewListPlaceName.text = place.nama
            itemView.textViewListPlacePlace.text = place.lokasi
            Glide.with(itemView.context)
                    .load(place.thumbnail)
                    .apply(RequestOptions()
                            .format(DecodeFormat.PREFER_ARGB_8888)
                            .placeholder(R.drawable.ic_image_placeholder)
                            .error(R.drawable.ic_image_placeholder)
                            .dontAnimate())
                    .into(itemView.circleImageViewListPlace)
        }

    }
}