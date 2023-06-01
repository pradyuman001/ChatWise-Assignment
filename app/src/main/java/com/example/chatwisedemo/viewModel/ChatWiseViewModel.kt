package com.example.chatwisedemo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatwisedemo.api.ApiClient.Companion.getRetrofit
import com.example.chatwisedemo.api.ApiInterface
import com.example.chatwisedemo.model.ChatWiseModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChatWiseViewModel : ViewModel() {

    var dataList = MutableLiveData<List<ChatWiseModelItem>>()

    init {
        viewModelScope.launch {
            dataList.postValue(getApiData() as List<ChatWiseModelItem>)
        }
    }

    private suspend fun getApiData(): List<ChatWiseModelItem>? {

        val apiInterface = getRetrofit().create(ApiInterface::class.java)

        return (withContext(Dispatchers.IO) {
            apiInterface.getData().body()
        })

    }

}