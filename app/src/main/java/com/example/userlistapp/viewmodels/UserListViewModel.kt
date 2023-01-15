package com.example.userlistapp.viewmodels

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.example.userlistapp.models.UserList
import com.example.userlistapp.models.UserListItem
import com.example.userlistapp.networking.RetrofitClient
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class UserListViewModel : ViewModel() {

    private val _userListStateFlow = MutableStateFlow<List<UserListItem>>(emptyList())
    val userListStateFlow: StateFlow<List<UserListItem>> = _userListStateFlow

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun getAllUserList(){
        _isLoading.value = true
        val userList = mutableListOf<UserListItem>()

        viewModelScope.launch {
            val response = RetrofitClient.getInstance().getAllUsers("8634366274bd23efb9b023fb9b2c6502e67f7dd5d6a7962b3b49fbee170940f8")
            _isLoading.value = false

            if (response.isSuccessful){
                Log.d("UserList", "getAllUserList: ${response.body().toString()}")
                response.body()?.let { userList.addAll(it) }
                _userListStateFlow.value = userList
            } else{
                Log.d("ErrorOccured", "getAllUserList: ${response.code()}")
            }
        }
    }

    /*companion object{
        @BindingAdapter("imageUrl")
        fun setImage(image: ImageView, url: String?) {
            Glide.with(image.context).load(url)
                .into(image)
        }
    }*/
}