package com.yoesuv.mvpnetworking.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yoesuv.mvpnetworking.R
import com.yoesuv.mvpnetworking.datas.Constants
import com.yoesuv.mvpnetworking.menu.gallery.views.MainGalleryActivity
import com.yoesuv.mvpnetworking.menu.listplace.views.MainListPlaceActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_top.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonListPlace.setOnClickListener {
            startActivity(Intent(this, MainListPlaceActivity::class.java))
        }
        buttonGallery.setOnClickListener {
            startActivity(Intent(this, MainGalleryActivity::class.java))
        }

        setupToolbar()
    }

    private fun setupToolbar(){
        setSupportActionBar(toolbarMain.toolbarInclude)
        supportActionBar?.title = getString(R.string.app_name)
        supportActionBar?.elevation = Constants.TOOLBAR_ELEVATION
    }
}
