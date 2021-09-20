package com.example.and_eval4.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Type (
    @PrimaryKey(autoGenerate = true)
    var typeId: Long = 0,
    var name:String
)