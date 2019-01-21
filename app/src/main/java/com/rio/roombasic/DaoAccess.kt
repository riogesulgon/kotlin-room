package com.rio.roombasic

import androidx.room.*


@Dao
interface DaoAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOnlySingleMovie(movies: Movies)

    @Insert
    fun insertMultipleMovies( moviesList: List<Movies>)

    @Query("SELECT * FROM Movies WHERE movieId = :movieId")
    fun  fetchOneMoviesbyMovieId (movieId:Int): Movies

    @Update
    fun updateMovie ( movies:Movies)

    @Delete
    fun deleteMovie ( movies: Movies)
}