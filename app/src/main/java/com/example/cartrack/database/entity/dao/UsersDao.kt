package com.example.cartrack.database.entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cartrack.database.entity.Country
import com.example.cartrack.database.entity.User

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user : User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(countries : List<Country>)

    @Query("SELECT * FROM country")
    suspend fun getCountries(): List<Country>

    @Query("SELECT * FROM user WHERE username = :username")
    suspend fun getUser(username : String): User
}