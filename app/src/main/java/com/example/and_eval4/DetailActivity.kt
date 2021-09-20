package com.example.and_eval4

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.and_eval4.databinding.ActivityDetailBinding
import com.example.and_eval4.viewmodel.ExpenseDetailViewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        val EXPENSE_ID_EXTRA = "EXPENSE_ID"
    }
    private var id: Long? = null
    private lateinit var expenseListViewModel: ExpenseDetailViewModel
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        }
    }
