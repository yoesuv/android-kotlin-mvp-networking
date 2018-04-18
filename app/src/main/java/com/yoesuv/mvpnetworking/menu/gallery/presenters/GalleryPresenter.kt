package com.yoesuv.mvpnetworking.menu.gallery.presenters

import com.yoesuv.mvpnetworking.datas.Constants
import com.yoesuv.mvpnetworking.menu.gallery.contracts.GalleryContract
import com.yoesuv.mvpnetworking.networks.ServiceFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 *  Created by yusuf on 4/18/18.
 */
class GalleryPresenter(private val viewGallery: GalleryContract.ViewGallery): GalleryContract.Presenter {

    private var restApi = ServiceFactory.create()
    private val compositeDisposable = CompositeDisposable()

    override fun getListGallery() {
        viewGallery.showLoading()
        compositeDisposable.add(
                restApi.getListGallery()
                        .timeout(Constants.TIME_OUT, TimeUnit.MILLISECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io()).subscribeBy(
                                onNext = {
                                    viewGallery.setData(it)
                                },
                                onError = {
                                    viewGallery.dismissLoading()
                                },
                                onComplete = {
                                    viewGallery.dismissLoading()
                                }
                        )
        )
    }

    override fun destroy() {
        compositeDisposable.clear()
    }

}