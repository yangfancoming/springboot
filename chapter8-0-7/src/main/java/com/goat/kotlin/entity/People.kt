package com.goat.kotlin.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by Administrator on 2018/1/23.
 */

@Entity
class People(

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,
        private val firstName: String?,
        private val lastName: String?,
        private val gender: String?,
        private val age: Int?,
        private val gmtCreated: Date,
        private val gmtModified: Date
) {
    override fun toString(): String {
        return "People(id=$id, firstName='$firstName', lastName='$lastName', gender='$gender', age=$age, gmtCreated=$gmtCreated, gmtModified=$gmtModified)"
    }
}