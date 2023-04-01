package com.myapplication.execiseprojecttest.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.utils.NetworkResult
import com.myapplication.execiseprojecttest.data.api.models.Execises
import com.myapplication.execiseprojecttest.domain.usecases.GetAllExecisesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllExecisesUseCase: GetAllExecisesUseCase):ViewModel() {

    private val _execises =MutableLiveData<NetworkResult<Execises>>()
    val execises:LiveData<NetworkResult<Execises>>
        get() = _execises
    init {
        loadExecises()
    }
    private fun loadExecises(){
        viewModelScope.launch {
            getAllExecisesUseCase.invoke()?.let {
                _execises.value = it
            }
        }
    }
}