package com.yoesuv.mvpnetworking.menu.listplace.contracts

import com.yoesuv.mvpnetworking.menu.listplace.models.ListPlaceModel

/**
 *  Created by yusuf on 4/17/18.
 */
class ListPlaceContract {

    interface ViewListPlace{
        fun setData(listPlaceModel: ListPlaceModel)
    }

    interface Presenter{
        fun getListPlace()
        fun destroy()
    }
}