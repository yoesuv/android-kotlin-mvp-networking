package com.yoesuv.mvpnetworking.menu.listplace.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import com.yoesuv.mvpnetworking.R
import com.yoesuv.mvpnetworking.datas.Constants
import com.yoesuv.mvpnetworking.menu.listplace.contracts.ListPlaceContract
import com.yoesuv.mvpnetworking.menu.listplace.models.ListPlaceModel
import com.yoesuv.mvpnetworking.menu.listplace.presenters.ListPlacePresenter
import kotlinx.android.synthetic.main.activity_list_place.*
import kotlinx.android.synthetic.main.activity_list_place.view.*

/**
 *  Created by yusuf on 4/17/18.
 */
class MainListPlaceActivity: AppCompatActivity(), ListPlaceContract.ViewListPlace {

    private lateinit var listPlacePresenter: ListPlacePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_place)

        listPlacePresenter = ListPlacePresenter(this)
        listPlacePresenter.getListPlace()

        setupToolbar()
        setupSwipeRefresh()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        listPlacePresenter.destroy()
    }

    private fun setupToolbar(){
        toolbarListPlace.textViewTitleToolbar.text = getString(R.string.list_place)
        setSupportActionBar(toolbarListPlace)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = Constants.TOOLBAR_ELEVATION
    }

    private fun setupSwipeRefresh(){
        swipeRefreshListPlace.setOnRefreshListener {
            listPlacePresenter.getListPlace()
        }
    }

    override fun setData(listPlaceModel: ListPlaceModel) {
        Log.d(Constants.RESULT_DEBUG,"MainListPlaceActivity # jumlah tempat ${listPlaceModel.data.size}")
    }

    override fun showLoading() {
        swipeRefreshListPlace.isRefreshing = true
    }

    override fun dismissLoading() {
        swipeRefreshListPlace.isRefreshing = false
    }
}