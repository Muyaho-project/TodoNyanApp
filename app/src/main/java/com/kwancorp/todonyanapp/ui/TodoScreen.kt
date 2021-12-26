package com.kwancorp.todonyanapp.ui

import com.kwancorp.todonyanapp.R

enum class TodoScreen(
    val title: String,
    val iconRes: Int
) {
    Home(
        title = "Home",
        iconRes = R.drawable.ic_home
    ),
    Cat(
        title = "Cat",
        iconRes = R.drawable.ic_bottom_cat
    ),
    My(
        title = "My",
        iconRes = R.drawable.ic_bottom_my
    );

    companion object {
        fun fromRoute(route: String?): TodoScreen =
            when (route?.substringBefore("/")) {
                Home.name -> Home
                Cat.name -> Cat
                My.name -> My
                null -> Home
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}