package com.rio.roombasic


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Movies::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun daoAccess(): DaoAccess
    companion object {

        // For Singleton instantiation
        @Volatile private var instance: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): MovieDatabase {
            return Room.databaseBuilder(context, MovieDatabase::class.java, "movies_database")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}