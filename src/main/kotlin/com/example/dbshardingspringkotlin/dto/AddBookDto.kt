package com.example.dbshardingspringkotlin.dto


data class AddBookDto(
    var name:String?=null,
    var userId:Int?=null,
) {
    constructor() : this(null,null)
}