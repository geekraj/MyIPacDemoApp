package com.ipac.myipac.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Name")
@Parcelize
data class Name (
    val title: String,
    val first: String,
    val last: String
): Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}