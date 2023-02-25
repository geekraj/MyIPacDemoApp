package com.ipac.myipac.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Timezone")
@Parcelize
data class Timezone (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val offset: String,
    val description: String
): Parcelable