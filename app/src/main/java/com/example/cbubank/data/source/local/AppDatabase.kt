package com.example.cbubank.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cbubank.data.models.ValyutData
import kotlinx.coroutines.selects.SelectInstance

@Database(entities = [ValyutData::class], version = 1)
abstract class AppDatabase :RoomDatabase(){
    abstract fun cbuDao():CbuDao
    companion object{
        private lateinit var instance:AppDatabase
        fun init(context: Context){
            if(!Companion::instance.isInitialized){
                instance = Room.databaseBuilder(context,AppDatabase::class.java,"Database.db")
                    .allowMainThreadQueries()
                    .build()
            }
        }
        fun getInstance() = instance
    }
}