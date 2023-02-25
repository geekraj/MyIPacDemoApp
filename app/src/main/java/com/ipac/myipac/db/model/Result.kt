package com.ipac.myipac.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Users")
@Parcelize
class Result (@PrimaryKey(autoGenerate = true) val idKey: Int,
              val gender: String? = null,
              val name: Name? = null,
              val location: Location? = null,
              val email: String? = null,
              val login: Login? = null,
              val registered: Registered? = null,
              val phone: String? = null,
              val cell: String? = null,
              val id: ID? = null,
              val picture: Picture? = null,
              val nat: String? = null): Parcelable


