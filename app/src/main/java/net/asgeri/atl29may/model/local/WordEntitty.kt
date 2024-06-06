package net.asgeri.atl29may.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("words")
data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("word_id")
    val id: Int = 0,
    val english: String? = null,
    val turkish: String
)