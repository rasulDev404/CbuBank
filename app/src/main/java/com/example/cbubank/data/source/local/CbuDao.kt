package com.example.cbubank.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cbubank.data.models.ResponseData
import com.example.cbubank.data.models.ValyutData

@Dao
interface CbuDao {

    @Insert
    fun insert(vararg valyutData: ValyutData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(valyutData: List<ValyutData>)

    @Update
    fun update(vararg valyutData: ValyutData)

    @Update
    fun update(valyutData: List<ValyutData>)

    @Delete
    fun delete(valyutData: List<ValyutData>)

    @Query("SELECT * FROM cbu")
    fun getAllValyuts():LiveData<List<ValyutData>>

    @Query("DELETE FROM cbu")
    fun deleteAll()

    @Transaction
    fun updateAllValyuts(newList:List<ValyutData>){
        deleteAll()
        insert(newList)
    }

}