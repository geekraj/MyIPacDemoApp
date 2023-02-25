package com.ipac.myipac.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ipac.myipac.db.model.Login

class LoginTypeConverter {
    @TypeConverter
    fun stringToLogin(json: String): Login {
        val gson = Gson()
        val type = object : TypeToken<Login>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun loginToString(list: Login): String {
        val gson = Gson()
        val type = object : TypeToken<Login>() {}.type
        return gson.toJson(list, type)
    }
}