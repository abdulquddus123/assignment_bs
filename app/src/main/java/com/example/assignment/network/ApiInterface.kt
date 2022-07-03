package com.jetpack.callapimvvm.network

import com.example.assignment.model.UserInfoModel
import com.example.assignment.model.UserResponse
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface ApiInterface {

    @GET("search/repositories?q=android")
    suspend fun getUserData(): UserInfoModel
}