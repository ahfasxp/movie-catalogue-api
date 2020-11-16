@file:Suppress("DEPRECATION")

package com.ahfasxp.moviecatalogue.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.ahfasxp.moviecatalogue.R
import com.ahfasxp.moviecatalogue.utils.DataDummy
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyShow = DataDummy.generateDummyTvshow()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadMovie() {
        delay2seconds()
        //Memastikan rv_movie dalam keadaan tampil
        onView(allOf(withId(R.id.rv_movie), isDisplayed()))
        //Gulir rv_movie ke posisi data terakhir
        onView(
            allOf(
                withId(R.id.rv_movie),
                isDisplayed()
            )
        ).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        delay2seconds()
        //Memberi tindakan klik pada data pertama di rv_movie
        onView(allOf(withId(R.id.rv_movie), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        delay2seconds()
        //Memastikan ImageVIew tampil sesuai yang diharapkan
        onView(allOf(withId(R.id.img_poster), isDisplayed()))
        //Memastikan TextView tampil sesuai yang diharapkan
        onView(allOf(withId(R.id.tv_title), isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))
        onView(allOf(withId(R.id.tv_tagline), isDisplayed()))
        onView(withId(R.id.tv_tagline)).check(matches(withText(dummyMovie[0].tagline)))
        onView(allOf(withId(R.id.tv_overview), isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyMovie[0].overview)))
    }

    @Test
    fun loadShow() {
        //Klik TabLayout dengan teks tvshow
        onView(withText("TV SHOW")).perform(ViewActions.click())
        delay2seconds()
        //Memastikan rv_show dalam keadaan tampil
        onView(allOf(withId(R.id.rv_show), isDisplayed()))
        //Gulir rv_show ke posisi data terakhir
        onView(
            allOf(
                withId(R.id.rv_show),
                isDisplayed()
            )
        ).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyShow.size))
    }

    @Test
    fun loadDetailShow() {
        //Klik TabLayout dengan teks tvshow
        onView(allOf(withText("TV SHOW"), isDisplayed())).perform(ViewActions.click())
        delay2seconds()
        //Memberi tindakan klik pada data pertama di rv_movie
        onView(allOf(withId(R.id.rv_show), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        delay2seconds()
        //Memastikan ImageVIew tampil sesuai yang diharapkan
        onView(allOf(withId(R.id.img_poster), isDisplayed()))
        //Memastikan TextView tampil sesuai yang diharapkan
        onView(allOf(withId(R.id.tv_title), isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyShow[0].title)))
        onView(allOf(withId(R.id.tv_tagline), isDisplayed()))
        onView(withId(R.id.tv_tagline)).check(matches(withText(dummyShow[0].tagline)))
        onView(allOf(withId(R.id.tv_overview), isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyShow[0].overview)))
    }

    private fun delay2seconds() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}