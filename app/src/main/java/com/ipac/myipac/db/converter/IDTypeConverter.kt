package com.ipac.myipac.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ipac.myipac.db.model.ID

class IDTypeConverter {
    @TypeConverter
    fun stringToID(json: String): ID {
        val gson = Gson()
        val type = object : TypeToken<ID>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun iDToString(list: ID): String {
        val gson = Gson()
        val type = object : TypeToken<ID>() {}.type
        return gson.toJson(list, type)
    }
}