package com.ipac.myipac.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ipac.myipac.db.model.Picture

class PictureTypeConverter {
    @TypeConverter
    fun stringToPicture(json: String): Picture {
        val gson = Gson()
        val type = object : TypeToken<Picture>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun pictureToString(list: Picture): String {
        val gson = Gson()
        val type = object : TypeToken<Picture>() {}.type
        return gson.toJson(list, type)
    }
}