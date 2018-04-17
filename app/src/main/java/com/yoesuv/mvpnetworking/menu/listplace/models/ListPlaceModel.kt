package com.yoesuv.mvpnetworking.menu.listplace.models

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 *  Created by yusuf on 4/17/18.
 */
data class ListPlaceModel (

    @JsonProperty("status_code") val statusCode:Int,
    @JsonProperty("data") val data:List<Place>){

        @JsonInclude(JsonInclude.Include.NON_NULL)
        class Place(
                @JsonProperty("name") val nama:String?,
                @JsonProperty("lokasi") val lokasi:String?,
                @JsonProperty("deskripsi") val deskripsi:String?,
                @JsonProperty("thumbnail") val thumbnail:String?,
                @JsonProperty("gambar") val gambar:String?
        )
}