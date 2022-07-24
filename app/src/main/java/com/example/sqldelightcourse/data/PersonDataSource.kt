package com.example.sqldelightcourse.data

import crashcourse.personalDB.PersonEntity
import kotlinx.coroutines.flow.Flow

interface PersonDataSource {

    suspend fun getPersonById(id: Long): PersonEntity?

    fun getAllPersons(): Flow<List<PersonEntity>>

    suspend fun deletePersonById(id:Long)

    suspend fun insertPerson(firstname: String, lastName: String, id: Long? = null)
}