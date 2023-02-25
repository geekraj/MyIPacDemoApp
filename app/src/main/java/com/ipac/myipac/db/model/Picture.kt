package com.ipac.myipac.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Picture")
@Parcelize
data class Picture (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val large: String,
    val medium: String,
    val thumbnail: String
): Parcelable