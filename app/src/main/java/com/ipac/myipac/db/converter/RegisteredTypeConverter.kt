package com.ipac.myipac.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ipac.myipac.db.model.Dob
import com.ipac.myipac.db.model.Registered

class RegisteredTypeConverter {
    @TypeConverter
    fun stringToRegistered(json: String): Registered {
        val gson = Gson()
        val type = object : TypeToken<Registered>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun registeredToString(list: Registered): String {
        val gson = Gson()
        val type = object : TypeToken<Registered>() {}.type
        return gson.toJson(list, type)
    }
}