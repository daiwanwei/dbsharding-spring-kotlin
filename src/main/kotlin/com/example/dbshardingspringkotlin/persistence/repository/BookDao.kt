package com.example.dbshardingspringkotlin.persistence.repository

import com.example.dbshardingspringkotlin.persistence.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookDao:JpaRepository<Book,Long> {
}