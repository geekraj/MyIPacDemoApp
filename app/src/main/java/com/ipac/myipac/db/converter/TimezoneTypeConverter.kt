package com.ipac.myipac.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ipac.myipac.db.model.Timezone

class TimezoneTypeConverter {
    @TypeConverter
    fun stringToTimezone(json: String): Timezone {
        val gson = Gson()
        val type = object : TypeToken<Timezone>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun timezoneToString(list: Timezone): String {
        val gson = Gson()
        val type = object : TypeToken<Timezone>() {}.type
        return gson.toJson(list, type)
    }
}