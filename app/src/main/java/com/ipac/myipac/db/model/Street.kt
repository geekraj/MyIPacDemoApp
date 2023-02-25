package com.ipac.myipac.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Street")
@Parcelize
data class Street (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val number: Long,
    val name: String
): Parcelable