package com.example.androiddevchallenge.ui.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.ui.dao.DogInfo

@Composable
fun DogDetailsScreen(info : DogInfo) {
    Text(text = info.name)
}