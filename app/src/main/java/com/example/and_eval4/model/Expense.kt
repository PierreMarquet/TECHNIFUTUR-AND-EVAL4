package com.example.and_eval4.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.util.*


@Entity
data class Expense (
    @PrimaryKey(autoGenerate = true)
    var expenseId: Long = 0,
    var name: String,
    var date: Date,
    var value: Float,
)

/*
@TypeConverter
fun fromTimestamp(value: Long?): Date? {
    return value?.let { Date(it) }
}
*/