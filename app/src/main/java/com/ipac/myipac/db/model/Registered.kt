package com.ipac.myipac.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Dob")
@Parcelize
data class Registered (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val date: String,
    val age: Long
): Parcelable