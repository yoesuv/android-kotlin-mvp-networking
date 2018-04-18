package com.yoesuv.mvpnetworking.menu.gallery.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *  Created by yusuf on 4/18/18.
 */
data class GalleryModel (

        @SerializedName("status_code") @Expose val statusCode:Int?,
        @SerializedName("data") @Expose val listGallery: MutableList<Gallery>) {

    class Gallery(
            @SerializedName("caption") @Expose val caption: String?,
            @SerializedName("thumbnail") @Expose val thumbnail: String?,
            @SerializedName("image") @Expose val image:String?
    )
}