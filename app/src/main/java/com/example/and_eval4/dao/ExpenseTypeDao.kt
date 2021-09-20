package com.example.and_eval4.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.and_eval4.model.ExpenseType

@Dao
interface ExpenseTypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expenseType: ExpenseType)
}