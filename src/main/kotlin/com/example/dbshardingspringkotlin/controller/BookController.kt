package com.example.dbshardingspringkotlin.controller
import com.example.dbshardingspringkotlin.dto.AddBookDto
import com.example.dbshardingspringkotlin.persistence.model.Book
import com.example.dbshardingspringkotlin.persistence.repository.BookDao
import com.example.dbshardingspringkotlin.utils.ResponseDto
import org.springframework.web.bind.annotation.*


@RequestMapping("/book")
@RestController
class BookController(private val bookDao: BookDao) {
    @GetMapping("/findAllBook")
    fun findAllBook():ResponseDto.Data<List<Book>>{
        return try {
            val books=bookDao.findAll()
            ResponseDto.Data(200,"ok",books)
        }catch (e:Exception){
            ResponseDto.Data(500,e.message,null)
        }
    }

    @PostMapping("/addBook")
    fun addBook(@RequestBody addBookDto: AddBookDto):ResponseDto.NonData{
        return try {
            val book= Book(addBookDto.name,addBookDto.userId)
            bookDao.save(book)
            ResponseDto.NonData(200,"ok")
        }catch (e:Exception){
            ResponseDto.NonData(500,e.message)
        }
    }


}