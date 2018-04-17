package com.yoesuv.mvpnetworking.menu.listplace.presenters

import com.yoesuv.mvpnetworking.datas.Constants
import com.yoesuv.mvpnetworking.menu.listplace.contracts.ListPlaceContract
import com.yoesuv.mvpnetworking.networks.ServiceFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 *  Created by yusuf on 4/17/18.
 */
class ListPlacePresenter(private val viewListPlace: ListPlaceContract.ViewListPlace) : ListPlaceContract.Presenter {

    private var restApi = ServiceFactory.create()
    private val compositeDisposable = CompositeDisposable()

    override fun getListPlace() {
        viewListPlace.showLoading()
        compositeDisposable.add(
            restApi.getListPlace()
                    .timeout(Constants.TIME_OUT, TimeUnit.MILLISECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribeBy(
                            onNext = {
                                viewListPlace.setData(it)
                            },
                            onError = {
                                viewListPlace.dismissLoading()
                            },
                            onComplete = {
                                viewListPlace.dismissLoading()
                            }
                    )
        )
    }

    override fun destroy() {
        compositeDisposable.clear()
    }
}