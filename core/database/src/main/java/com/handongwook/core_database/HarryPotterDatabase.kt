package com.handongwook.harry_potter.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [],
    version = 1,
    exportSchema = true,
)
//@TypeConverters(value = [])
abstract class HarryPotterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}