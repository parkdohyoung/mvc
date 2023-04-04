package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import javax.validation.constraints.*

data class UserRequest(
    @field:NotEmpty
    @field:Size(min=2,max=8)
    var name:String? = null,

    @field:PositiveOrZero // 0< 숫자를 검증 0도 포함 ( 양수)
    var age:Int?=null,

    @field:Email // email 양식
    var email:String?=null,

    @field:NotBlank //공백을 검증
    var address:String? = null,

    @field:Pattern(regexp="^\\d{2,3}-\\d{3,4}-\\d{4}\$")
    var phoneNumber:String?=null
)