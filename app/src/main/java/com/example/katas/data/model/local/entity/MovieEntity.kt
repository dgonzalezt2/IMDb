package com.example.katas.data.model.local.entity


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movies_local")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0 ,
    val title: String?,
    val rating: String?,
    val posterPath: String?

)
