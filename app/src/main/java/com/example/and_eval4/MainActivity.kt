package com.example.and_eval4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.and_eval4.databinding.ActivityMainBinding
import com.example.and_eval4.model.Expense
import com.example.and_eval4.ui.ExpenseAdapter
import com.example.and_eval4.viewmodel.ExpenseListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var expenseListViewModel: ExpenseListViewModel
    private lateinit var adapter: ExpenseAdapter
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        expenseListViewModel = ViewModelProvider(this).get(ExpenseListViewModel::class.java)
        val dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.addExpense) {
            startActivity(Intent(this, AddExpenseActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }


}