package com.example.and_eval4.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.and_eval4.model.Expense
import com.example.and_eval4.model.ExpenseWithType

@Dao
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expense:Expense): Long

    @Query("SELECT * FROM expense")
    fun getAll(): LiveData<List<Expense>>

    @Query("SELECT * FROM expense WHERE expenseId = :expenseId LIMIT 1")
    fun findExpenseWithTypeById(expenseId: Long): LiveData<ExpenseWithType>

    @Query("DELETE FROM expense WHERE expenseId = :expenseId")
    suspend fun deleteExpense(expenseId: Long)
}