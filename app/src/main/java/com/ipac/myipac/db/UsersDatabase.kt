package com.ipac.myipac.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ipac.myipac.db.converter.*
import com.ipac.myipac.db.model.*
import com.ipac.myipac.db.model.Result

@Database(
    entities = [Result::class, ID::class, Location::class, Login::class, Name::class, Picture::class, Street::class, Timezone::class, Coordinates::class, Registered::class],
    version = 1, exportSchema = false
)
@TypeConverters(
    Converters::class,
    LocationTypeConverter::class,
    LoginTypeConverter::class,
    NameTypeConverter::class,
    PictureTypeConverter::class,
    StreetTypeConverter::class,
    TimezoneTypeConverter::class,
    RegisteredTypeConverter::class,
    IDTypeConverter::class
)
abstract class UsersDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}