package com.goat.kotlin.repository

import com.goat.kotlin.entity.People
import org.springframework.data.repository.CrudRepository


/**
 * Created by Administrator on 2018/1/23.
 */

interface PeopleRepository : CrudRepository<People, Long> {
    fun findByLastName(lastName: String): List<People>?
}
