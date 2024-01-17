package com.alat.roadmap.repository

import android.util.Log
import com.alat.roadmap.network.GetDataService
import com.alat.roadmap.network.Todo
import com.alat.roadmap.utils.RequestStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class TodoRepository(private val apiService: GetDataService) {

    suspend fun fetchTodosFromApi(): RequestStatus<List<Todo>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getAllTodos()
                if (response.isSuccessful) {
                    RequestStatus.Success(response.body() ?: emptyList())
                } else {
                    Log.d("fetchTodoFromApi", response.message() ?: "Error fetching todos")
                    RequestStatus.Error("Error fetching todos")
                }
            } catch (e: Exception) {
                Log.e("fetchTodoFromApi", e.localizedMessage ?: "Unable to process request")
                RequestStatus.Error("Unable to process request")
            }
        }
    }

    suspend fun getTodosFromApi() = flow {
        emit(apiService.getTodoItems())
    }

}