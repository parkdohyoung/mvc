package com.example.mvc.controller.response

import com.example.mvc.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.io.IOException
import java.nio.file.Path
import java.nio.file.Files
import kotlin.io.path.Path


@RestController
@RequestMapping("/api/response")
class ResponseApiController {
    // 1. get 4xx
    //GET http://localhost:8080/api/response
    @GetMapping("")
    fun getmapping(@RequestParam age : Int?): ResponseEntity<String>{
        //0. age == null  -> 400 error

        return age?.let {
            // age not null
            if(age < 20 ){
                return ResponseEntity.status(400).body("age 값이 20 이하 입니다.")
            }
            ResponseEntity.ok("OK")


        }?: kotlin.run {
            //age is null
            return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
        }

        /*
        if(age == null){
            return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
        }

        //1. age <20 -> 400 error
        if(age < 20 ){
            return ResponseEntity.status(400).body("age 값이 20 이하 입니다.")
        }

        println(age)
        return ResponseEntity.ok("OK")
        */
    }

    // 2. post 200

    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<Any> {
        return ResponseEntity.status(200).body(/* body = */ userRequest) // object mapper -> object -> json

    }


    // 3. put 201
    @PutMapping
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<Any> {
        //1. 기존 데이터가 없어서 새로 생성했다.
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }
    // 4. delete 500

    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id:Int): ResponseEntity<Any> {

        val path = Path("/")
        try {
            val size = Files.size(path)
            return ResponseEntity.status(500).body("${size} is deleted")
        }
        catch (e: IOException){
            e.printStackTrace()
        }
        return ResponseEntity.status(500).body("${id} is deleted")
    }

}