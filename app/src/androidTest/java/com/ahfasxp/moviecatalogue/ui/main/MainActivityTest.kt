package com.ahfasxp.moviecatalogue.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.ahfasxp.moviecatalogue.R
import com.ahfasxp.moviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyShow = DataDummy.generateDummyTvshow()

    @get:Rule
    var mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadMovie() {
        //Memastikan rv_movie dalam keadaan tampil
        onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        //Gulir rv_movie ke posisi data terakhir
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        //Memberi tindakan klik pada data pertama di rv_movie
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        //Memastikan ImageVIew tampil sesuai yang diharapkan
        onView(withId(R.id.img_poster)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.img_poster)).check(ViewAssertions.matches(withText(dummyMovie[0].poster_path)))
        //Memastikan TextView tampil sesuai yang diharapkan
        onView(withId(R.id.tv_title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_title)).check(ViewAssertions.matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_tagline)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_tagline)).check(ViewAssertions.matches(withText(dummyMovie[0].tagline)))
        onView(withId(R.id.tv_overview)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_overview)).check(ViewAssertions.matches(withText(dummyMovie[0].overview)))
    }

    @Test
    fun loadShow() {
        //Klik TabLayout dengan teks tvshow
        onView(withText("Tv Show")).perform(ViewActions.click())
        //Memastikan rv_show dalam keadaan tampil
        onView(withId(R.id.rv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        //Gulir rv_show ke posisi data terakhir
        onView(withId(R.id.rv_show))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyShow.size))
    }

    @Test
    fun loadDetailShow() {
        //Klik TabLayout dengan teks tvshow
        onView(withText("Tv Show")).perform(ViewActions.click())
        //Memberi tindakan klik pada data pertama di rv_movie
        onView(withId(R.id.rv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        //Memastikan ImageVIew tampil sesuai yang diharapkan
        onView(withId(R.id.img_poster)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.img_poster)).check(ViewAssertions.matches(withText(dummyShow[0].poster_path)))
        //Memastikan TextView tampil sesuai yang diharapkan
        onView(withId(R.id.tv_title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_title)).check(ViewAssertions.matches(withText(dummyShow[0].title)))
        onView(withId(R.id.tv_tagline)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_tagline)).check(ViewAssertions.matches(withText(dummyShow[0].tagline)))
        onView(withId(R.id.tv_overview)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_overview)).check(ViewAssertions.matches(withText(dummyShow[0].overview)))
    }
}