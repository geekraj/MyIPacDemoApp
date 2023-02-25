package com.ipac.myipac.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ipac.myipac.db.model.Dob

class DobTypeConverter {
    @TypeConverter
    fun stringToDob(json: String): Dob {
        val gson = Gson()
        val type = object : TypeToken<Dob>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun dobToString(list: Dob): String {
        val gson = Gson()
        val type = object : TypeToken<Dob>() {}.type
        return gson.toJson(list, type)
    }
}