package com.yoesuv.mvpnetworking.menu.gallery.models

import com.fasterxml.jackson.annotation.JsonProperty

/**
 *  Created by yusuf on 4/18/18.
 */
data class GalleryModel (

    @JsonProperty("status_code") val statusCode:Int?,
    @JsonProperty("data") val listGallery: MutableList<Gallery>) {

    class Gallery(
            @JsonProperty("caption") val caption: String?,
            @JsonProperty("thumbnail") val thumbnail: String?,
            @JsonProperty("image") val image:String?
    )
}