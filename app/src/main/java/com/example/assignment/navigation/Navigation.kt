package com.example.assignment.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class Navigation {

    private val _sharedFlow =
        MutableSharedFlow<NavTarget>(extraBufferCapacity = 1)
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun navigateTo(navTarget: NavTarget) {
        _sharedFlow.tryEmit(navTarget)
    }

    enum class NavTarget(val label: String) {

        Home("home"),
        Detail("detail")
    }
}
sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object DetailScreen : NavRoutes("detailscreen/{user}")
}