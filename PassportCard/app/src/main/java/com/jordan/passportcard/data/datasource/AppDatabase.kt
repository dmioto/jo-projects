package com.jordan.passportcard.data.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jordan.passportcard.data.datasource.local.PassportCardDao
import com.jordan.passportcard.domain.entity.PassportCard

@Database(entities = [PassportCard::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun passportCardDao(): PassportCardDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "businesscard_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}