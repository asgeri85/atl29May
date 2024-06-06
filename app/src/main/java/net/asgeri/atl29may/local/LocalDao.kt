package net.asgeri.atl29may.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.asgeri.atl29may.model.local.WordEntity

@Dao
interface LocalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addWord(wordEntity: WordEntity)

    @Query("SELECT * FROM words")
    suspend fun getWords(): List<WordEntity>

}