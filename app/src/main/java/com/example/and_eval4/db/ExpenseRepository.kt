package com.example.and_eval4.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.and_eval4.model.Expense
import com.example.and_eval4.model.ExpenseType
import com.example.and_eval4.model.ExpenseWithType
import com.example.and_eval4.model.Type
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExpenseRepository {
    companion object {
        var expenseDatabase: ExpenseDatabase? = null
        var expense: LiveData<ExpenseWithType>? = null


        fun initDB(context: Context) : ExpenseDatabase {
            val db = ExpenseDatabase.getDB(context)
            CoroutineScope(Dispatchers.IO).launch {
                val types = db.typeDao().getAllTypes()
                if(types.isNullOrEmpty()){
                    db.typeDao().insert(Type(name = "Tax"))
                    db.typeDao().insert(Type(name = "Electricity"))
                    db.typeDao().insert(Type(name = "Water"))
                }
            }
            return db
        }

        fun insertExpense(
            context: Context,
            name: String,
            date: String,
            value: Int?,
            selectedTypes: String
        ) {
            expenseDatabase = initDB(context)
            CoroutineScope(Dispatchers.IO).launch {
                val expense = Expense(name = name, date = date, value = value)
                val expenseId = expenseDatabase!!.expenseDao().insert(expense)
                selectedTypes.forEach {
                    val typeId = it.typeId
                    expenseDatabase!!.expenseTypeDao().insert(ExpenseType(expenseId = expenseId, typeId = typeId))
                }
            }
        }

        fun insertType(context: Context, name: String) {
            if(expenseDatabase == null) {
                expenseDatabase = initDB(context)
            }
            CoroutineScope(Dispatchers.IO).launch {
                val type = Type(name = name)
                expenseDatabase!!.typeDao().insert(type)
            }
        }

        fun getExpenseDetails(context: Context, id: Long) : LiveData<ExpenseWithType>? {
            if(expenseDatabase == null) {
                expenseDatabase = initDB(context)
            }
            expense = expenseDatabase!!.expenseDao().findExpenseWithTypeById(id)
            return expense
        }

        fun getAllExpenses(context: Context): LiveData<List<Expense>> {
            if(expenseDatabase == null) {
                expenseDatabase = initDB(context)
            }
            return expenseDatabase!!.expenseDao().getAll()
        }

        fun getAllTypes(context: Context): LiveData<List<Type>> {
            if(expenseDatabase == null) {
                expenseDatabase = initDB(context)
            }
            return expenseDatabase!!.typeDao().getAll()
        }

        fun deleteExpense(context: Context, expenseId: Long) {
            if(expenseDatabase == null) {
                expenseDatabase = initDB(context)
            }
            expenseDatabase?.let { db ->
                CoroutineScope(Dispatchers.IO).launch {
                    db.expenseDao().deleteExpense(expenseId)
                }
            }
        }
    }
}