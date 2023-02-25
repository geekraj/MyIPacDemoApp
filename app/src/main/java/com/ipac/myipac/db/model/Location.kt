package com.ipac.myipac.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Location")
@Parcelize
data class Location (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val timezone: Timezone
): Parcelable