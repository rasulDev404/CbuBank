package com.example.cbubank.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cbu")
data class ValyutData(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val name:String,
    val shortName:String,
    val rate:String,
    val diff:String,
    val date:String
)
