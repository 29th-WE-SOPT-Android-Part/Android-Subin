package com.example.androidsopt.network

import com.example.androidsopt.data.RequestSignUpData
import com.example.androidsopt.data.ResponseSignUpData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SignUpService {
    @Headers("Content-Type: application/json")
    @POST("user/signup")
    fun postSignup(
            @Body body : RequestSignUpData
    ) :Call<ResponseSignUpData>
}