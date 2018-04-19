package com.yoesuv.mvpnetworking.menu.listplace.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *  Created by yusuf on 4/17/18.
 */
data class ListPlaceModel (

        @SerializedName("status_code") @Expose val statusCode:Int,
        @SerializedName("data") @Expose val data:List<Place>){

        class Place(
                @SerializedName("nama") @Expose val nama:String?,
                @SerializedName("lokasi") @Expose val lokasi:String?,
                @SerializedName("deskripsi") @Expose val deskripsi:String?,
                @SerializedName("thumbnail") @Expose val thumbnail:String?,
                @SerializedName("gambar") @Expose val gambar:String?
        )
}