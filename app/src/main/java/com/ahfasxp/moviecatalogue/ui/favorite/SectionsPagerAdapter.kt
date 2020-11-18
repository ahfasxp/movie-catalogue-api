package com.ahfasxp.moviecatalogue.ui.favorite

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ahfasxp.moviecatalogue.R
import com.ahfasxp.moviecatalogue.ui.favorite.favoriteMovie.FavoriteMovieFragment
import com.ahfasxp.moviecatalogue.ui.favorite.favoriteTvshow.FavoriteShowFragment

class SectionsPagerAdapter(private val mContext: FavoriteFragment, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        private val TAB_TITLES = intArrayOf(R.string.tabs_text_1, R.string.tabs_text_2)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavoriteMovieFragment()
            1 -> FavoriteShowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? =
        mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = TAB_TITLES.size
}