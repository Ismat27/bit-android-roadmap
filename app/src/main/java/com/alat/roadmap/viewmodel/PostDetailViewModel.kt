package com.alat.roadmap.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.alat.roadmap.RoadMapApplication
import com.alat.roadmap.network.Post
import com.alat.roadmap.repository.IPostDetailRepository
import com.alat.roadmap.utils.RequestStatus
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PostDetailViewModel(private val repo: IPostDetailRepository) : ViewModel() {

    private val _uiState = MutableLiveData<RequestStatus<Post>>(RequestStatus.Loading())

    val uiState: LiveData<RequestStatus<Post>> = _uiState

    fun fetchPost(postId: Int) = viewModelScope.launch {
        val item = repo.fetchPostDetailFromApi(postId)
        if (item == null) {
            _uiState.postValue(RequestStatus.Error(""))
        } else {
            _uiState.postValue(RequestStatus.Success(item))
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as RoadMapApplication)
                val repo = application.postDetailRepository
                PostDetailViewModel(repo)
            }
        }
    }

}