package com.example.cbubank.presenters

import androidx.lifecycle.LiveData
import com.example.cbubank.data.models.ValyutData

interface MainViewModel {

    val listLiveData:LiveData<List<ValyutData>>

    val progressLiveData:LiveData<Boolean>

    val openDialogLiveData:LiveData<ValyutData>

    fun itemClick(valyutData: ValyutData)

    fun getAllData()

  //  fun writeToDatabase()

    fun updateAllData()
}