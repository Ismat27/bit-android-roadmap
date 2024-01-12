package com.alat.roadmap.repository

import android.util.Log
import com.alat.roadmap.network.Post
import com.alat.roadmap.network.RetrofitClientInstance
import com.alat.roadmap.utils.RequestStatus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository {

    fun fetchPostFromApi(callback: (RequestStatus<List<Post>>) -> Unit) {
        var responseBody: RequestStatus<List<Post>> = RequestStatus.Loading()
        callback(responseBody)
        try {
            RetrofitClientInstance.getInstance()?.getDataService()?.getPosts()?.enqueue(object :
                Callback<List<Post>> {
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    responseBody = if (response.isSuccessful) {
                        val items = response.body() ?: emptyList()
                        RequestStatus.Success(items)
                    } else {
                        Log.d("fetchPostFromApi", response.message() ?: "Posts fetch failed")
                        RequestStatus.Error("Posts fetch failed")
                    }
                    callback(responseBody)

                }
                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    Log.e("fetchPostFromApi", t.localizedMessage ?: "Unable to fetch posts")
                    responseBody = RequestStatus.Error("Unable to fetch posts")
                    callback(responseBody)
                }
            })
        } catch (e: Exception) {
            Log.e("fetchPostFromApi", e.localizedMessage ?: "error fetching posts")
            responseBody = RequestStatus.Error("error fetching posts")
            callback(responseBody)
        }
    }

}