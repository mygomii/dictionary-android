package com.mygomii.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mygomii.data.local.dao.WordDao
import com.mygomii.data.local.entity.WordEntity

@Database(entities = [WordEntity::class], version = 1)
abstract class WordDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
}
