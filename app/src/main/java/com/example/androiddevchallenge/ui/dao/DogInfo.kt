package com.example.androiddevchallenge.ui.dao



data class DogInfo(
    var id : Int = 0,
    var name : String,
    var species : String,
    var age : Int,
    var icon : String? = null,
    var habits : String
)

val tempData by lazy {
    mutableListOf<DogInfo>().apply {
        add(DogInfo(0,"","",1,null,""))
        add(DogInfo(1,"","",1,null,""))
        add(DogInfo(2,"","",1,null,""))
    }
}