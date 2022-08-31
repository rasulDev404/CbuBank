package com.example.cbubank.presenters.impl

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cbubank.data.models.ValyutData
import com.example.cbubank.presenters.MainViewModel
import com.example.cbubank.repositroy.ValyutRepository
import com.example.cbubank.repositroy.impl.ValyutRepositoryImpl

class MainViewModelImpl : MainViewModel, ViewModel() {

    private val repository: ValyutRepository = ValyutRepositoryImpl()

    override val listLiveData: MutableLiveData<List<ValyutData>> = MutableLiveData()

    override val progressLiveData: MediatorLiveData<Boolean> = MediatorLiveData()

    override val openDialogLiveData: MutableLiveData<ValyutData> = MutableLiveData()

    override fun itemClick(valyutData: ValyutData) {
        openDialogLiveData.value = valyutData
    }

    override fun getAllData() {
        progressLiveData.addSource(repository.getRoomData()) {
            listLiveData.value = it
        }
        updateAllData()
    }

    override fun updateAllData() {
        repository.updateAllToDatabase()
    }

    init {
        getAllData()
    }
}