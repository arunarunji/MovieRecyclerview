package com.example.listview

data class Person(val name:String, val lastName:String, val gender: Gender, val nationality:String) {


    enum class Gender {
        MALE, FEMALE
    }

}