package com.aamirashraf.runningtrackerapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Run::class], version = 1)
@TypeConverters(Converters::class)
abstract class RunDatabase :RoomDatabase(){
    abstract fun getRunDao():RunDao
    //here we are not going to use the singleton pattern
    //because we are going to use the dagger dependencies  dagger will handle it
}