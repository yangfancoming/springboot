package com.goat.kotlin.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by 64274 on 2019/3/6.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/6---17:59
 */
@RestController
@RequestMapping(value = "/api/data")
class DataController {

    @RequestMapping(value = "",method = [RequestMethod.GET, RequestMethod.PUT])
    fun index():Map<String,Any>{
        val resultMap = HashMap<String,Any>()

        resultMap["status"] = true
        resultMap["msg"] = "success"
        return resultMap
    }

    @RequestMapping(value = "show",method = [RequestMethod.PUT],consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun test(@RequestBody reqMap:Map<Any,Any>):Map<Any,Any>{
        return reqMap
    }
}