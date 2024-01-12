package com.alat.roadmap.network

import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    @GET("/todos")
    fun getTodos(): Call<List<Todo>>
}