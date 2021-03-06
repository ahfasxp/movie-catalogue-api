package com.ahfasxp.moviecatalogue.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.koin.core.context.loadKoinModules

class FavoriteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            loadKoinModules(viewModelModule)

            //Setup ViewPager
            val sectionsPagerAdapter =
                SectionsPagerAdapter(this, childFragmentManager)
            vp_favorite.adapter = sectionsPagerAdapter
            tabs_favorite.setupWithViewPager(vp_favorite)
        }
    }
}