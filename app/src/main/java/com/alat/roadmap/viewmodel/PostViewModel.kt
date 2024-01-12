package com.alat.roadmap.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.alat.roadmap.network.Post
import com.alat.roadmap.repository.PostRepository
import com.alat.roadmap.utils.RequestStatus

class PostViewModel(private val postRepository: PostRepository) : ViewModel() {

    private val _postUiState =
        MutableLiveData<RequestStatus<List<Post>>>(RequestStatus.Uninitialized())

    val postUiState: LiveData<RequestStatus<List<Post>>> = _postUiState

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
         postRepository.fetchPostFromApi { getPostFromApiCall(it) }
    }

    private fun getPostFromApiCall(response: RequestStatus<List<Post>>) {
        _postUiState.postValue(response)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repo = PostRepository()
                PostViewModel(repo)
            }
        }
    }

}