package com.example.and_eval4.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.and_eval4.db.ExpenseRepository
import com.example.and_eval4.model.ExpenseWithType

internal class ExpenseDetailViewModel: ViewModel() {
    var liveDataExpense: LiveData<ExpenseWithType>? = null

    fun getExpense(context: Context, expenseId: Long): LiveData<ExpenseWithType>? {
        liveDataExpense = ExpenseRepository.getExpenseDetails(context, expenseId)
        return liveDataExpense
    }

    fun deleteExpense(context: Context, expenseId: Long) {
        ExpenseRepository.deleteExpense(context, expenseId)
    }
}