package com.yoesuv.mvpnetworking.networks

import com.yoesuv.mvpnetworking.menu.listplace.models.ListPlaceModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 *  Created by yusuf on 4/17/18.
 */
interface RestApi {

    @GET("3e17a05acc63f4e696ba4cb15d3b9f2f/raw/3e879b1c5cfe652ca25a18019ca4bc219f20177d/daftar_tempat.json")
    fun getListPlace():Observable<ListPlaceModel>

}