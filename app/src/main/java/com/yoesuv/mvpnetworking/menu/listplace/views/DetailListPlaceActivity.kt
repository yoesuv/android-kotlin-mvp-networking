package com.yoesuv.mvpnetworking.menu.listplace.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.yoesuv.mvpnetworking.R
import com.yoesuv.mvpnetworking.datas.Constants
import com.yoesuv.mvpnetworking.menu.listplace.models.ListPlaceModel
import kotlinx.android.synthetic.main.detail_list_place.*
import kotlinx.android.synthetic.main.toolbar_top.view.*

/**
 *  Created by yusuf on 4/20/18.
 */
class DetailListPlaceActivity: AppCompatActivity() {

    companion object {
        const val EXTRA_DATA_LIST_PLACE:String = "extra_data_list_place"
    }

    private lateinit var place: ListPlaceModel.Place

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_list_place)

        place = intent.getSerializableExtra(EXTRA_DATA_LIST_PLACE) as ListPlaceModel.Place

        setupToolbar()
        setupData()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupToolbar(){
        toolbarDetailListPlace.textViewTitleToolbar.text = place.nama
        setSupportActionBar(toolbarDetailListPlace)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = Constants.TOOLBAR_ELEVATION
    }

    private fun setupData(){
        textViewDetailListPlace.text = place.deskripsi
        Glide.with(this.applicationContext)
                .load(place.gambar)
                .apply(RequestOptions()
                        .placeholder(R.drawable.image_placeholder)
                        .error(R.drawable.image_placeholder).format(DecodeFormat.PREFER_ARGB_8888))
                .into(imageViewDetailListPlace)
    }

}