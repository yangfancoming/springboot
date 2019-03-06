package com.easy.kotlin


import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
open class KotlinApplication

fun main(args: Array<String>){
    SpringApplication.run(KotlinApplication::class.java,*args)
}
