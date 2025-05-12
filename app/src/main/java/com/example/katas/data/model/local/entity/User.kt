package com.example.katas.data.model.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
 data class User(
     @PrimaryKey(autoGenerate = true) val id: Int = 0,
     val name:String,
     val email: String,
     val password: String //encriptar la contrasena
                        
 )


