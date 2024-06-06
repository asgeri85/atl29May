package net.asgeri.atl29may.local

import androidx.room.Database
import androidx.room.RoomDatabase
import net.asgeri.atl29may.model.local.WordEntity

@Database(entities = [WordEntity::class], version = 1)
abstract class WordDatabase : RoomDatabase() {

    abstract fun createDAO(): LocalDao
}