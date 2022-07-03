package com.example.assignment.viewmodel

import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment.model.UserInfoModel
import com.example.assignment.repository.UserRespository
import com.example.assignment.model.Items
import com.jetpack.callapimvvm.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRespository: UserRespository
): ViewModel() {

    var isLoading = mutableStateOf(false)
    private var _getUserData: MutableLiveData<List<Items>> = MutableLiveData<List<Items>>()
    var getUserData: LiveData<List<Items>> = _getUserData
     var setDetails:MutableLiveData<Items> = MutableLiveData<Items>()
            var getDetails:LiveData<Items> = setDetails


    suspend fun getUserData(): Resource<UserInfoModel> {
        val result = userRespository.getUserResponse()
        if (result is Resource.Success) {
            isLoading.value = true
            _getUserData.value = result.data!!.items
        }

        return result
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun String?.dateChangeTo(inputType: String, outputType: String): String {
        val finalDate: String?
        val input = SimpleDateFormat(inputType, Locale.UK)
        val output = SimpleDateFormat(outputType, Locale.UK)

        finalDate = try {
            val inputDate = input.parse(this) // parse input
            output.format(inputDate)
        } catch (e: Exception) {
            ""
        }
        return finalDate ?: ""
    }
}