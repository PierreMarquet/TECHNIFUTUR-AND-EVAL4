package com.example.and_eval4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.and_eval4.databinding.ActivityAddExpenseBinding
import com.example.and_eval4.db.ExpenseRepository
import com.example.and_eval4.model.Type

class AddExpenseActivity : AppCompatActivity() {

    private lateinit var types: List<Type>
    private var selectedTypes: ArrayList<Type> = arrayListOf()
    lateinit var binding: ActivityAddExpenseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ExpenseRepository.getAllTypes(this).observe(this) {
            this.types = it
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_expense, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.saveExpense) {
            val name = binding.editTextTextPersonName.text.toString()
            val date = binding.editTextTextPersonName3.text.toString()
            val value = binding.editTextTextPersonName2.text.toString().toIntOrNull()
            val type = binding.editTextTextPersonName4.text.toString()
            if(name.isNotBlank() && date.isNotBlank() && type.isNotBlank() && value != null) {
                ExpenseRepository.insertExpense(this, name, date, value, type)
                finish()
            } else {
                Toast.makeText(this, "Invalid Data", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}