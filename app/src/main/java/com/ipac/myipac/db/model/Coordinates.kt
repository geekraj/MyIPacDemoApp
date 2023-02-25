package com.ipac.myipac.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Coordinates")
@Parcelize
data class Coordinates (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val latitude: String,
    val longitude: String
): Parcelable