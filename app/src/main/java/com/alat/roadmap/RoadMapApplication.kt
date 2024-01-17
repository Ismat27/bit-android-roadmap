package com.alat.roadmap

import android.app.Application
import com.alat.roadmap.network.GetDataService
import com.alat.roadmap.repository.PostDetailRepository
import com.alat.roadmap.repository.PostRepository
import com.alat.roadmap.repository.TodoRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://jsonplaceholder.typicode.com"

class RoadMapApplication : Application() {

    private val okHttpBuilder = OkHttpClient.Builder()
        .readTimeout(3, TimeUnit.MINUTES)
        .connectTimeout(3, TimeUnit.MINUTES)

    private val mRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpBuilder.build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService: GetDataService by lazy {
        mRetrofit.create(GetDataService::class.java)
    }

    val postRepository: PostRepository by lazy {
        PostRepository(apiService)
    }

    val postDetailRepository: PostDetailRepository by lazy {
        PostDetailRepository(apiService)
    }

    val todoRepository: TodoRepository by lazy {
        TodoRepository(apiService)
    }

}