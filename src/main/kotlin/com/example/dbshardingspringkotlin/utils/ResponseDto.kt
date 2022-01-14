package com.example.dbshardingspringkotlin.utils

class ResponseDto {
    data class Data<T>(
        val code:Int?,
        val msg:String?,
        val data:T?,
    )

    data class NonData(
        val code:Int?,
        val msg:String?,
    )
}