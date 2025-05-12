package com.example.katas.data.model.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.katas.data.model.local.entity.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  registerUser(user: User)


    @Query("SELECT * FROM user_table WHERE  email = :email AND password = :password ")
    suspend fun  loginUser(email: String, password: String): User?
}