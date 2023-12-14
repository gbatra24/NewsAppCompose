package com.gagan.newsapp.ui.screens

sealed class Screen (val route: String) {
    data object HomeScreen : Screen("home_screen")
    data object SavedScreen : Screen("saved_screen")
    data object DetailScreen : Screen("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
