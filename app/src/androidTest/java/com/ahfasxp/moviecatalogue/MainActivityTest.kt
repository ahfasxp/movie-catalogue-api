package com.ahfasxp.moviecatalogue

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.ahfasxp.moviecatalogue.core.utils.DataDummy
import com.ahfasxp.moviecatalogue.utils.EspressoIdlingResource
import org.hamcrest.core.AllOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyShow = DataDummy.generateDummyTvshow()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadMovie() {
        //Memastikan rv_movie dalam keadaan tampil
        Espresso.onView(AllOf.allOf(ViewMatchers.withId(R.id.rv_movie), ViewMatchers.isDisplayed()))
        //Gulir rv_movie ke posisi data terakhir
        Espresso.onView(
            AllOf.allOf(
                ViewMatchers.withId(R.id.rv_movie),
                ViewMatchers.isDisplayed()
            )
        ).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        //Memberi tindakan klik pada data pertama di rv_movie
        Espresso.onView(AllOf.allOf(ViewMatchers.withId(R.id.rv_movie), ViewMatchers.isDisplayed()))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
        //Memastikan ImageVIew tampil sesuai yang diharapkan
        Espresso.onView(
            AllOf.allOf(
                ViewMatchers.withId(R.id.img_poster),
                ViewMatchers.isDisplayed()
            )
        )
        //Memastikan TextView tampil sesuai yang diharapkan
        Espresso.onView(AllOf.allOf(ViewMatchers.withId(R.id.tv_title), ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_title))
            .check(ViewAssertions.matches(withText(dummyMovie[0].title)))
        Espresso.onView(
            AllOf.allOf(
                ViewMatchers.withId(R.id.tv_tagline),
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(ViewMatchers.withId(R.id.tv_tagline))
            .check(ViewAssertions.matches(withText(dummyMovie[0].tagline)))
        Espresso.onView(
            AllOf.allOf(
                ViewMatchers.withId(R.id.tv_overview),
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(ViewMatchers.withId(R.id.tv_overview))
            .check(ViewAssertions.matches(withText(dummyMovie[0].overview)))
    }

    @Test
    fun loadShow() {
        //Klik BottomNavigation dengan teks tvshow
        Espresso.onView(AllOf.allOf(ViewMatchers.withText("TV Show"), ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())
        //Memastikan rv_show dalam keadaan tampil
        Espresso.onView(AllOf.allOf(ViewMatchers.withId(R.id.rv_show), ViewMatchers.isDisplayed()))
        //Gulir rv_show ke posisi data terakhir
        Espresso.onView(
            AllOf.allOf(
                ViewMatchers.withId(R.id.rv_show),
                ViewMatchers.isDisplayed()
            )
        ).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailShow() {
        //Klik BottomNavigation dengan teks tvshow
        Espresso.onView(AllOf.allOf(ViewMatchers.withText("TV Show"), ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())
        //Memberi tindakan klik pada data pertama di rv_movie
        Espresso.onView(AllOf.allOf(ViewMatchers.withId(R.id.rv_show), ViewMatchers.isDisplayed()))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
        //Memastikan ImageVIew tampil sesuai yang diharapkan
        Espresso.onView(
            AllOf.allOf(
                ViewMatchers.withId(R.id.img_poster),
                ViewMatchers.isDisplayed()
            )
        )
        //Memastikan TextView tampil sesuai yang diharapkan
        Espresso.onView(AllOf.allOf(ViewMatchers.withId(R.id.tv_title), ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_title))
            .check(ViewAssertions.matches(withText(dummyShow[0].title)))
        Espresso.onView(
            AllOf.allOf(
                ViewMatchers.withId(R.id.tv_tagline),
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(ViewMatchers.withId(R.id.tv_tagline))
            .check(ViewAssertions.matches(withText(dummyShow[0].tagline)))
        Espresso.onView(
            AllOf.allOf(
                ViewMatchers.withId(R.id.tv_overview),
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(ViewMatchers.withId(R.id.tv_overview))
            .check(ViewAssertions.matches(withText(dummyShow[0].overview)))
    }

//    @Test
//    fun loadFavorite() {
//        //Klik BottomNavigation dengan teks favorite
//        Espresso.onView(AllOf.allOf(ViewMatchers.withText("Favorite"), ViewMatchers.isDisplayed()))
//            .perform(ViewActions.click())
//        //Memastikan rv_favorite_movie dalam keadaan tampil
//        Espresso.onView(AllOf.allOf(withId(R.id.rv_favorite_movie), ViewMatchers.isDisplayed()))
//        //Klik TabLayput dengan text tvshow
//        Espresso.onView(AllOf.allOf(ViewMatchers.withText("TV SHOW"), ViewMatchers.isDisplayed()))
//            .perform(ViewActions.click())
//        //Memastikan rv_favorite_show dalam keadaan tampil
//        Espresso.onView(AllOf.allOf(withId(R.id.rv_favorite_show), ViewMatchers.isDisplayed()))
//    }
}