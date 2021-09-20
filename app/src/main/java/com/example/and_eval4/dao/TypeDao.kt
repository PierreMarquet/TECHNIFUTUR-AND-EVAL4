package com.example.and_eval4.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.and_eval4.model.Type

@Dao
interface TypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(type: Type): Long

    @Query("SELECT * FROM Type")
    fun getAll(): LiveData<List<Type>>

    @Query("SELECT * FROM type")
    suspend fun getAllTypes(): List<Type>
}