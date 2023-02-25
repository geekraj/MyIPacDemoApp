package com.ipac.myipac.ui.main

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipac.myipac.db.model.Result
import com.ipac.myipac.db.model.UserResponse
import com.ipac.myipac.repository.UsersRepository
import com.ipac.myipac.util.ApiResult
import com.ipac.myipac.util.SingleLiveEvent
import kotlinx.coroutines.launch

class MainViewModel(private val usersRepository: UsersRepository) : ViewModel() {
    val isShowLoading = ObservableBoolean()
    val usersList = MutableLiveData<List<Result>?>()
    val iShowError = SingleLiveEvent<String?>()

    fun getUsers(result: Int) {
        isShowLoading.set(true)
        viewModelScope.launch {
            val result = usersRepository.getUsers(result)

            isShowLoading.set(false)
            when (result) {
                is ApiResult.Success -> {
                    val response = result.successData as UserResponse
                    usersList.postValue(response.results)
                    iShowError.value = null
                }
                else -> iShowError.value = "Something went wrong"
            }
        }
    }
}