package com.goat.kotlin.service

import com.goat.kotlin.entity.People
import com.goat.kotlin.repository.PeopleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class PeopleService : PeopleRepository {

    override fun deleteById(id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun <S : People?> saveAll(entities: MutableIterable<S>): MutableIterable<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun findAllById(ids: MutableIterable<Long>): MutableIterable<People> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun existsById(id: Long): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun findById(id: Long): Optional<People> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun deleteAll(entities: MutableIterable<People>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Autowired
    val peopleRepository: PeopleRepository? = null


    override fun findByLastName(lastName: String): List<People>? {
        return peopleRepository?.findByLastName(lastName)
    }

    override fun <S : People?> save(entity: S): S? {
        return peopleRepository?.save(entity)
    }


    override fun delete(entity: People?) {
    }


    override fun findAll(): MutableIterable<People>? {
        return peopleRepository?.findAll()
    }

    override fun count(): Long {
        return peopleRepository?.count()!!
    }


    override fun deleteAll() {
    }


}
