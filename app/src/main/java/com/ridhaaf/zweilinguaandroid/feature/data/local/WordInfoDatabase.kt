package com.ridhaaf.zweilinguaandroid.feature.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ridhaaf.zweilinguaandroid.feature.data.local.entities.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class WordInfoDatabase: RoomDatabase() {
    abstract val dao: WordInfoDao
}