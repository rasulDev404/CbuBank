package com.example.cbubank.presenters.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cbubank.presenters.SplashViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModelImpl() : SplashViewModel,ViewModel() {

    override val openMainScreenLiveData: MutableLiveData<Unit> = MutableLiveData()
    init {
        viewModelScope.launch {
            delay(2000)
            openMainScreenLiveData.postValue(Unit)
        }
    }


}