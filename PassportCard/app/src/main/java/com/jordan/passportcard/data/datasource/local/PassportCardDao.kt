package com.jordan.passportcard.data.datasource.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jordan.passportcard.domain.entity.PassportCard

@Dao
interface PassportCardDao {

    @Query("SELECT * FROM PassportCard")
    fun getAll(): LiveData<List<PassportCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(passportCard: PassportCard)

}