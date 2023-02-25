package com.ipac.myipac.db
import androidx.room.Dao
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ipac.myipac.db.model.Result
import androidx.room.Insert as Insert1


@Dao
interface UserDao {
    @Query("SELECT * FROM Users")
    fun getUsers(): List<Result>

    @Insert1(onConflict = OnConflictStrategy.REPLACE)
    fun add(users: List<Result>)
}