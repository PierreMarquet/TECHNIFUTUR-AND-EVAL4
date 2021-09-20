package com.example.and_eval4.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

@Entity(primaryKeys = ["expenseId", "typeId"])
data class ExpenseType(
    var expenseId: Long,
    var typeId: Long
)

data class ExpenseWithType(
    @Embedded
    val expense: Expense,
    @Relation(
        parentColumn = "expenseId",
        entityColumn = "typeId",
        associateBy = Junction(ExpenseType::class)
    )
    val genres: List<Type>
)

data class TypeWithExpense(
    @Embedded
    val genre: Type,
    @Relation(
        parentColumn = "typeId",
        entityColumn = "expenseId",
        associateBy = Junction(ExpenseType::class)
    )
    val expenses: List<Expense>
)