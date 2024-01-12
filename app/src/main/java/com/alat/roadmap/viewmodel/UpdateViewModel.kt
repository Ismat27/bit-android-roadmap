package com.alat.roadmap.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.alat.roadmap.repository.UpdateRepository
import com.alat.roadmap.utils.RequestStatus


class UpdateViewModel(private val updateRepository: UpdateRepository) : ViewModel() {

    private val _updateStatus =
        MutableLiveData<RequestStatus<String>>(RequestStatus.Uninitialized())

    val updateStatus: LiveData<RequestStatus<String>> = _updateStatus

    fun update(email: String, newPassword: String) {
        _updateStatus.value = RequestStatus.Loading()
        val response = updateRepository.sendPasswordUpdateRequest(email, newPassword)
        if (response == "success") {
            _updateStatus.value = RequestStatus.Success(response)
        } else {
            _updateStatus.value = RequestStatus.Error("Unable to password")
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repo = UpdateRepository()
                UpdateViewModel(repo)
            }
        }
    }


}