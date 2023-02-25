package com.ipac.myipac.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ipac.myipac.db.model.Name

class NameTypeConverter {
    @TypeConverter
    fun stringToName(json: String): Name {
        val gson = Gson()
        val type = object : TypeToken<Name>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun nameToString(list: Name): String {
        val gson = Gson()
        val type = object : TypeToken<Name>() {}.type
        return gson.toJson(list, type)
    }
}