package com.alvarosct02.moviesdemo.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alvarosct02.moviesdemo.BuildConfig
import com.alvarosct02.moviesdemo.data.local.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = MoviesDemoDatabase.DATABASE_VERSION)
abstract class MoviesDemoDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private var INSTANCE: MoviesDemoDatabase? = null
        private const val DATABASE_NAME = BuildConfig.DATABASE_NAME
        const val DATABASE_VERSION = 1

        fun getInstance(context: Context): MoviesDemoDatabase {
            if (INSTANCE == null) {
                synchronized(MoviesDemoDatabase::class) {
                    INSTANCE = buildRoomDB(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildRoomDB(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MoviesDemoDatabase::class.java,
                DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}
