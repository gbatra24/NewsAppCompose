package com.gagan.newsapp.ui.screens

import org.junit.Assert
import org.junit.Test


class ScreenTest {

    @Test
    fun withArgs() {
        Assert.assertEquals("home_screen/test", Screen.HomeScreen.withArgs("test"))
    }

    @Test
    fun getRoute() {
        Assert.assertEquals("home_screen", Screen.HomeScreen.route)
        Assert.assertEquals("saved_screen", Screen.SavedScreen.route)
        Assert.assertEquals("detail_screen", Screen.DetailScreen.route)
    }
}