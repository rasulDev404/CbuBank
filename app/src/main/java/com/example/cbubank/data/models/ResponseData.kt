package com.example.cbubank.data.models

import com.google.gson.annotations.SerializedName

data class ResponseData(
    val id:Int,
    val Code:String,
    val Ccy:String,
    @SerializedName("CcyNm_RU")
    val ru:String,
    @SerializedName("CcyNm_UZ")
    val uz:String,
    @SerializedName("CcyNm_UZC")
    val uzc:String,
    @SerializedName("CcyNm_EN")
    val eng:String,
    val Nominal:String,
    val Rate:String,
    val Diff:String,
    val Date:String

){
    fun toValyutData() = ValyutData(id,ru,Ccy,Rate,Diff,Date)


}
