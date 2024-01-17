package com.alat.roadmap.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.alat.roadmap.RoadMapApplication
import com.alat.roadmap.network.Todo
import com.alat.roadmap.repository.TodoRepository
import com.alat.roadmap.utils.RequestStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class TodoViewModel(private val todoRepository: TodoRepository) : ViewModel() {

    private val _uiState = MutableLiveData<RequestStatus<List<Todo>>>(RequestStatus.Uninitialized())
    val uiState: LiveData<RequestStatus<List<Todo>>> = _uiState


    private fun fetchTodos() = viewModelScope.launch {
        _uiState.postValue(todoRepository.fetchTodosFromApi())
    }

    private fun fetchTodoItems() = viewModelScope.launch {
        todoRepository.getTodosFromApi()
            .flowOn(Dispatchers.IO)
            .catch {
                _uiState.postValue(RequestStatus.Error("Request failed"))
                Log.e("fetchTodoItems", it.localizedMessage ?: "Request failed")
            }.collect {
                val items = it?.map { item -> item }
                _uiState.postValue(RequestStatus.Success(items ?: emptyList()))
            }
    }

    init {
//        fetchTodos()
        fetchTodoItems()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as RoadMapApplication)
                TodoViewModel(application.todoRepository)
            }
        }

    }

}