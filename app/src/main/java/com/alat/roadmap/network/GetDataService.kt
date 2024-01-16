package com.alat.roadmap.network

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GetDataService {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    @GET("posts/{id}")
    suspend fun getPostItemDetail(@Path("id") id: Int): Response<Post>

    @GET("/todos")
    fun getTodos(): Call<List<Todo>>

    @GET("/todos")
    suspend fun getAllTodos(): Response<List<Todo>>

    @GET("/todos")
    suspend fun getTodoItems(): List<Todo>
}