package net.asgeri.atl29may.local

import androidx.room.Database
import androidx.room.RoomDatabase
import net.asgeri.atl29may.model.ProductResponse

@Database(entities = [ProductResponse::class], version = 1)
abstract class LocalDataBase : RoomDatabase() {

    abstract fun createDAO(): ProductDAO
}