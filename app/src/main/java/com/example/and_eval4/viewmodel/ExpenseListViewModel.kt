package com.example.and_eval4.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.and_eval4.db.ExpenseRepository
import com.example.and_eval4.model.Expense
import com.example.and_eval4.model.Type

internal class ExpenseListViewModel: ViewModel() {
    var liveDataExpenseList: LiveData<List<Expense>>? = null

    fun getExpenses(context: Context): LiveData<List<Expense>> {
        return ExpenseRepository.getAllExpenses(context)
    }
}