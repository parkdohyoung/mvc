package com.example.mvc.controller.page

import com.example.mvc.model.http.UserRequest
import org.apache.catalina.User
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class pageController {

    @GetMapping("/main")
    fun main():String{
        println("init main")
        return "main.html"

    }

    @ResponseBody
    @GetMapping("/test")
    fun response():UserRequest{
       return UserRequest().apply {
            this.name ="Park"
        }
    //return "main.html"
    }
}