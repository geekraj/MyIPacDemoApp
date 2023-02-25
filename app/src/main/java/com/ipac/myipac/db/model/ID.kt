package com.ipac.myipac.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "ID")
@Parcelize
data class ID (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val value: String
): Parcelable