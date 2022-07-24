package com.example.sqldelightcourse.di

import android.app.Application
import com.example.sqldelightcourse.PersonDataBase
import com.example.sqldelightcourse.data.PersonDataSource
import com.example.sqldelightcourse.data.PersonDataSourceImpl
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Appmodule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver{
        return AndroidSqliteDriver(
            schema = PersonDataBase.Schema,
            context = app,
            name = "person.db"

        )
    }

    @Provides
    @Singleton
    fun providePersonDataSource(driver: SqlDriver): PersonDataSource {
        return PersonDataSourceImpl(PersonDataBase(driver))
    }
}