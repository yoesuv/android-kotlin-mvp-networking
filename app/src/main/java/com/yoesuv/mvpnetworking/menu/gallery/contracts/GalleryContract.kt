package com.yoesuv.mvpnetworking.menu.gallery.contracts

import com.yoesuv.mvpnetworking.menu.gallery.models.GalleryModel

/**
 *  Created by yusuf on 4/18/18.
 */
class GalleryContract {

    interface ViewGallery{
        fun showLoading()
        fun dismissLoading()
        fun setData(galleryModel: GalleryModel)
    }

    interface Presenter{
        fun getListGallery()
        fun destroy()
    }
}