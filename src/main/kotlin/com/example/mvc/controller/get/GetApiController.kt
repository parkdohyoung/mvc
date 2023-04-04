package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController // REST API 동적 선언
@RequestMapping("/api") // http://localhost:8080/api
class GetApiController {

    @GetMapping("/hello")
    fun hello():String{
        return "hello Kotlin"
    }
    @RequestMapping(method = [RequestMethod.GET], path =["/request-mapping"])
    fun requestMepping():String{
        return "request-mapping"
    }
        @GetMapping("/get-mapping/path-variable/{name}/{age}") //GET http:// localhost:8080/api/path-variable/name
    fun pathVariable(@PathVariable name:String, @PathVariable age:Int):String{
        println("${name}, ${age}")
        return name+" "+age
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}") //GET http:// localhost:8080/api/get-mapping/path-variable2
    fun pathVariable2(@PathVariable(value = "name") _name:String, @PathVariable(name = "age") _age:Int):String{
        val name = "kotlin"

        println("${_name}, ${_age}")
        return _name+" "+_age
    }


    //http://localhost:8080/api/page?key=value&key=value&key=value
    @GetMapping("/get-mapping/query-param")
    fun queryParam(
        @RequestParam(value = "name") _name: String,
        @RequestParam(value = "age") _age : Int
    ):String{
        println("${_name},${_age}")

        return "$_age $_name"
    }

    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest

    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map:Map<String,Any>): Any? {
        println(map)
        val phoneNumber = map.get("phone-number")
        return(map.get("phone-number"))
    }

}