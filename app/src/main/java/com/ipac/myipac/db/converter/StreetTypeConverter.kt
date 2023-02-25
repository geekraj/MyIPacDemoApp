package com.ipac.myipac.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ipac.myipac.db.model.Street

class StreetTypeConverter {
    @TypeConverter
    fun stringToStreet(json: String): Street {
        val gson = Gson()
        val type = object : TypeToken<Street>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun streetToString(list: Street): String {
        val gson = Gson()
        val type = object : TypeToken<Street>() {}.type
        return gson.toJson(list, type)
    }
}