package com.example.cbubank.repositroy.impl

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.cbubank.data.models.ResponseData
import com.example.cbubank.data.models.ValyutData
import com.example.cbubank.data.source.local.AppDatabase
import com.example.cbubank.data.source.remote.ApiClient
import com.example.cbubank.data.source.remote.CbuApi
import com.example.cbubank.repositroy.ValyutRepository
import com.example.cbubank.util.hasConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class ValyutRepositoryImpl : ValyutRepository{
    private val valyutDao = AppDatabase.getInstance().cbuDao()
    private val valyutApi = ApiClient.retrofit.create(CbuApi::class.java)

//    override fun addDataToDatabase() {
//        if(hasConnection()){
//            valyutApi.getAllValyuts().enqueue(object :Callback<List<ResponseData>>{
//                override fun onResponse(
//                    call: Call<List<ResponseData>>,
//                    response: Response<List<ResponseData>>
//                ) {
//                    Timber.d("Response")
//                    if(response.isSuccessful){
//                        Timber.d("Success")
//                        if(response.body() != null){
//                            val responseData = response.body()!!
//                            Timber.d(responseData.toString())
//                            valyutDao.insert(responseData.map {
//                                it.toValyutData()
//                            })
//                        }
//                    }
//                }
//
//                override fun onFailure(call: Call<List<ResponseData>>, t: Throwable) {
//                    Timber.d(t.message)
//                }
//
//            })
//        }
//    }

    override fun updateAllToDatabase() {
        if(hasConnection()){
            valyutApi.getAllValyuts().enqueue(object :Callback<List<ResponseData>>{
                override fun onResponse(
                    call: Call<List<ResponseData>>,
                    response: Response<List<ResponseData>>
                ) {
                    Timber.d("Response")
                    if(response.isSuccessful){
                        Log.d("TTT", "onResponse: bu7bffv1")
                        Timber.d("Success")
                        if(response.body() != null){
                            Log.d("TTT", "onResponse: bu7bffv2")
                            val responseData = response.body()!!
                            Timber.d(responseData.toString())
                            valyutDao.updateAllValyuts(responseData.map {
                                it.toValyutData()
                            })
                        }
                    }

                }
                override fun onFailure(call: Call<List<ResponseData>>, t: Throwable) {
                    Log.d("TTT", "onResponse: bu7bffv3")

                    Timber.d(t.message)
                }

            })
        }
    }


    override fun getRoomData(): LiveData<List<ValyutData>> = valyutDao.getAllValyuts()

}