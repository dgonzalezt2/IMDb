package com.example.katas.data.model.local.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.katas.data.model.local.entity.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun  movieInsertAll(movies: List<MovieEntity>)

    @Query("SELECT * FROM movies_local")
    suspend fun   getAllMovies(): List<MovieEntity>

    @Query("DELETE  FROM movies_local")
    suspend fun  deleteAllMovies()

}