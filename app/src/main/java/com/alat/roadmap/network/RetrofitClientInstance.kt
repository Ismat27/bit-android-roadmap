package com.alat.roadmap.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://jsonplaceholder.typicode.com"

class RetrofitClientInstance {

    private var mRetrofit: Retrofit? = null

    fun getDataService(): GetDataService? {
        return mRetrofit?.create(GetDataService::class.java)
    }

    fun reset() {
        mRetrofit = null
        getInstance()
    }

    init {
        val okHttpBuilder = OkHttpClient.Builder()
        okHttpBuilder.readTimeout(3, TimeUnit.MINUTES)
        okHttpBuilder.connectTimeout(3, TimeUnit.MINUTES)
        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {

        private var mInstance: RetrofitClientInstance? = null
        fun getInstance(): RetrofitClientInstance? {
            if (mInstance == null) {
                mInstance = RetrofitClientInstance()
            }
            return mInstance
        }
    }


}