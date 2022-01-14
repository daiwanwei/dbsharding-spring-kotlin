package com.example.dbshardingspringkotlin.persistence.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Book(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? =null,
        var name:String?=null,
        var userId:Int?=null,
){
        constructor(name:String?=null,userId:Int?=null):this(null,name,userId)
        constructor() : this(null, null,null)
}
