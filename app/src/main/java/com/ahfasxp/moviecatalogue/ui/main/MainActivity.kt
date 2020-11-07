package com.ahfasxp.moviecatalogue.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ahfasxp.moviecatalogue.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Setup ViewPager
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        vp_main.adapter = sectionsPagerAdapter
        tabs_main.setupWithViewPager(vp_main)

        supportActionBar?.elevation = 0f
    }
}