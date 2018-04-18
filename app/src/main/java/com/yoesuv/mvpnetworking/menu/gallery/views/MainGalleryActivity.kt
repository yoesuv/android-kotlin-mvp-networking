package com.yoesuv.mvpnetworking.menu.gallery.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import com.yoesuv.mvpnetworking.R
import com.yoesuv.mvpnetworking.datas.Constants
import com.yoesuv.mvpnetworking.menu.gallery.adapters.GalleryAdapter
import com.yoesuv.mvpnetworking.menu.gallery.contracts.GalleryContract
import com.yoesuv.mvpnetworking.menu.gallery.models.GalleryModel
import com.yoesuv.mvpnetworking.menu.gallery.presenters.GalleryPresenter
import kotlinx.android.synthetic.main.activity_gallery.*
import kotlinx.android.synthetic.main.activity_gallery.view.*

/**
 *  Created by yusuf on 4/17/18.
 */
class MainGalleryActivity: AppCompatActivity(), GalleryContract.ViewGallery {

    private lateinit var galleryPresenter: GalleryPresenter

    private var listGallery:MutableList<GalleryModel.Gallery> = arrayListOf()
    private lateinit var galleryAdapter:GalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        galleryPresenter = GalleryPresenter(this)
        galleryPresenter.getListGallery()

        setupToolbar()
        setupSwipeRefresh()
        setupRecycler()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        galleryPresenter.destroy()
    }

    private fun setupToolbar(){
        toolbarGallery.textViewTitleToolbar.text = getString(R.string.gallery)
        setSupportActionBar(toolbarGallery)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = Constants.TOOLBAR_ELEVATION
    }

    private fun setupSwipeRefresh(){
        swipeRefreshGallery.setOnRefreshListener {
            galleryPresenter.getListGallery()
        }
    }

    private fun setupRecycler(){
        val lManager = GridLayoutManager(this, 3)
        recyclerViewGallery.layoutManager = lManager
        galleryAdapter = GalleryAdapter(this, listGallery)
        recyclerViewGallery.adapter = galleryAdapter
    }

    override fun showLoading() {
        swipeRefreshGallery.isRefreshing = true
    }

    override fun dismissLoading() {
        swipeRefreshGallery.isRefreshing = false
    }

    override fun setData(galleryModel: GalleryModel) {
        Log.d(Constants.RESULT_DEBUG,"MainGalleryActivity # jumlah data gallery ${galleryModel.listGallery.size}")
        if(galleryModel.listGallery.isNotEmpty()){
            listGallery.clear()
            listGallery.addAll(galleryModel.listGallery)
            recyclerViewGallery.post {
                galleryAdapter.notifyDataSetChanged()
            }
        }
    }

}