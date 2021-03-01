package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.ui.dao.DogInfo
import com.example.androiddevchallenge.ui.dao.tempData

@Composable
fun DogListScreen(skipAdd : ()->Unit, skipDetails : (DogInfo)->Unit) {
    ToolBar()
    LazyColumn{
        val list = tempData
        items (list.size){
            DogListItem(dogInfo = list[it], skipDetails)
        }
    }
}

@Composable
private fun ToolBar() {

}

@Composable
private fun DogListItem(dogInfo: DogInfo, jumpDetails : (DogInfo)->Unit) {
    Button(onClick = {
        jumpDetails(dogInfo)
    }) {
        Text(text = dogInfo.name)
    }
}