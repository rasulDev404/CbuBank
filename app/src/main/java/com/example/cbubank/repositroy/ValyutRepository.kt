package com.example.cbubank.repositroy

import androidx.lifecycle.LiveData
import com.example.cbubank.data.models.ResponseData
import com.example.cbubank.data.models.ValyutData

interface ValyutRepository {

   // fun addDataToDatabase()

    fun updateAllToDatabase()

    fun getRoomData():LiveData<List<ValyutData>>

}