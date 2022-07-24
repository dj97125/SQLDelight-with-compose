package com.example.sqldelightcourse.data

import com.example.sqldelightcourse.PersonDataBase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import crashcourse.personalDB.PersonEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class PersonDataSourceImpl(
    db: PersonDataBase
) : PersonDataSource {

    private val queries = db.personEntityQueries

    override suspend fun getPersonById(id: Long): PersonEntity? {
        return withContext(Dispatchers.IO) {
            queries.getPersonById(id).executeAsOneOrNull()
        }
    }

    override fun getAllPersons(): Flow<List<PersonEntity>> {
        return queries.getAllPersons().asFlow().mapToList()
    }

    override suspend fun deletePersonById(id: Long) {
       withContext(Dispatchers.IO){
           queries.deletePersonById(id)
       }
    }

    override suspend fun insertPerson(firstname: String, lastName: String, id: Long?) {
        withContext(Dispatchers.IO){
            queries.insertPerson(id,firstname,lastName)
        }
    }

}