package com.alat.roadmap.repository

import android.util.Log
import com.alat.roadmap.network.GetDataService
import com.alat.roadmap.network.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface IPostDetailRepository {
    suspend fun fetchPostDetailFromApi(postId: Int): Post?
}

class PostDetailRepository(private val apiService: GetDataService) : IPostDetailRepository {

    override suspend fun fetchPostDetailFromApi(postId: Int): Post? {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getPostItemDetail(postId)
                if (response.isSuccessful) {
                    response.body()
                } else {
                    Log.d("fetchPostDetailFromApi", response.message() ?: "request failed")
                    null
                }
            } catch (e: Exception) {
                Log.e("fetchPostDetailFromApi", e.localizedMessage ?: "unable to process request")
                null
            }
        }
    }
}