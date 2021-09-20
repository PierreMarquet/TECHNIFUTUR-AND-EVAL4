package com.example.and_eval4.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.and_eval4.dao.ExpenseDao
import com.example.and_eval4.dao.ExpenseTypeDao
import com.example.and_eval4.dao.TypeDao
import com.example.and_eval4.model.Expense
import com.example.and_eval4.model.ExpenseType
import com.example.and_eval4.model.Type

@Database(entities = [Expense::class, ExpenseType::class, Type::class], version = 1)
abstract class ExpenseDatabase: RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
    abstract fun expenseTypeDao(): ExpenseTypeDao
    abstract fun typeDao(): TypeDao

    companion object {
        private var sharedInstance: ExpenseDatabase? = null

        fun getDB(context: Context): ExpenseDatabase {
            sharedInstance?.let {
                return it
            }
            synchronized(this) {
                sharedInstance = Room.databaseBuilder(context, ExpenseDatabase::class.java, "expense.db")
                    .fallbackToDestructiveMigration()
                    .build()
                return sharedInstance!!
            }
        }
    }
}