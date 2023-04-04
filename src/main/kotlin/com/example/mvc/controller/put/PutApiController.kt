package com.example.mvc.controller.put

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class PutApiController {
    @PutMapping("/put-mapping")
    fun putMapping():String{
        return  "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT] , path = ["/request-mapping"])
    fun requestMapping():String{
        return "request-mapping - put method"
    }

    @PutMapping(path=["/put-mapping/object"])
    fun putMappingObject(@RequestBody userRequest: UserRequest):UserResponse{
        //0. Response
        return UserResponse().apply{

            //1. Result
            this.result = Result().apply{
                this.resultCode = "OK"
                this.resultMessage="성공"
            }
        }.apply {
            //2. description
            this.description="~~~~~~~"

        }.apply {
            //3 user mutable List

            val userList = mutableListOf<UserRequest>()

            userList.add(userRequest)

            userList.add(UserRequest().apply {
                this.name = "a"
                this.address="a's Address"

                this.age=1
                this.email = "a@naver.com"
                this.phoneNumber="010-1234-5678"
            } )

            userList.add(UserRequest().apply {
                this.name = "b"
                this.address="a's Address"
                this.age=1
                this.email = "a@naver.com"
                this.phoneNumber="010-1234-5678"
            } )

            this.user = userList
        }

    }
}