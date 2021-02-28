package com.example.androiddevchallenge.ui.screen

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelStore

enum class ScreenType {List,Details,Add}
sealed class Screen(open val type : ScreenType) {
    data class List(override val type: ScreenType = ScreenType.List) : Screen(type)
    data class Add(override val type : ScreenType = ScreenType.Add) : Screen(type)
    data class Details(val detailsId : Int, override val type : ScreenType = ScreenType.Details) : Screen(type)
}
@Composable
fun DogScreen(onBack : OnBackPressedDispatcher, owner : LifecycleOwner) {
    val currentScreen = mutableStateOf<Screen>(Screen.List())
    val back = object : OnBackPressedCallback(false) {
        override fun handleOnBackPressed() {
            isEnabled = false
            currentScreen.value = Screen.List()
        }

    }
    onBack.addCallback(owner,back)
    when(currentScreen.value.type) {
        ScreenType.List -> {
            DogListScreen(skipAdd = {
                back.isEnabled = true
                currentScreen.value = Screen.Add()
            }, skipDetails = {
                back.isEnabled = true
                currentScreen.value = Screen.Details(it)
            })
        }
        ScreenType.Add -> {

        }
        ScreenType.Details -> {

        }
    }
}