package com.ipac.myipac.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ipac.myipac.db.model.Coordinates

class CoordinatesTypeConverter {
    @TypeConverter
    fun stringToCoordinates(json: String): Coordinates {
        val gson = Gson()
        val type = object : TypeToken<Coordinates>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun coordinatesToString(list: Coordinates): String {
        val gson = Gson()
        val type = object : TypeToken<Coordinates>() {}.type
        return gson.toJson(list, type)
    }
}