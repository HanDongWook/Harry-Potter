package com.handongwook.core_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [],
    version = 1,
    exportSchema = true,
)
//@TypeConverters(value = [])
abstract class HarryPotterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}