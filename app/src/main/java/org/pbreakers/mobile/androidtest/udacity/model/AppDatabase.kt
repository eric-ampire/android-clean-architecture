package org.pbreakers.mobile.androidtest.udacity.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import org.pbreakers.mobile.androidtest.udacity.model.dao.UserDao
import org.pbreakers.mobile.androidtest.udacity.model.entity.GithubUser
import java.util.*

@TypeConverters(value = [AppDatabase.DateConverter::class])
@Database(entities = [GithubUser::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    class DateConverter {
        @TypeConverter
        fun timestampToDate(timestamp: Long): Date = Date(timestamp)

        @TypeConverter
        fun dateToTimestamp(date: Date): Long = date.time
    }
}