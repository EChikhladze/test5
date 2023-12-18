package com.example.test5.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test5.api.CoursesResponse
import com.example.test5.api.Network
import com.example.test5.common.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class CoursesFragmentViewModel : ViewModel() {
    private val _responseFlow = MutableStateFlow<Resource<CoursesResponse>>(Resource.Loading(false))
    val responseFlow: SharedFlow<Resource<CoursesResponse>> = _responseFlow.asStateFlow()

    init {
        viewModelScope.launch {
            _responseFlow.value = Resource.Loading(true)
            try {
                val response = Network.coursesService().getCourses()
                if (response.isSuccessful) {
                    _responseFlow.value = Resource.Success(response.body()!!)
                } else {
                    _responseFlow.value = Resource.Error(response.message())
                }
            } catch (e: IOException) {
                _responseFlow.value = Resource.Error("Network error: ${e.localizedMessage}")
            } catch (e: HttpException) {
                _responseFlow.value = Resource.Error("HTTP error: ${e.localizedMessage}")
            } finally {
                _responseFlow.value = Resource.Loading(false)
            }
        }
    }
}