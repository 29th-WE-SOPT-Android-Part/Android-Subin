package com.example.androidsopt.network

import com.example.androidsopt.data.RequestSignInData
import com.example.androidsopt.data.ResponseSignInData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SignInService {
    @Headers("Content-Type: application/json")
    @POST("user/login")
    fun postLogin(
            @Body body : RequestSignInData
    ) : Call<ResponseSignInData>
}