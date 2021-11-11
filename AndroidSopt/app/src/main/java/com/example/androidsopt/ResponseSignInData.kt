package com.example.androidsopt

data class ResponseSignInData(

val status : Int,
val success : Boolean,
val message : String,
val data : ResponseLoginData.Data
){
    data class Data(
            val id : Int,
            val name : String,
            val email : String
    )
}

