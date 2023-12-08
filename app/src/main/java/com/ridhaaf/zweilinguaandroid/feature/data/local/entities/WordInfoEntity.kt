package com.ridhaaf.zweilinguaandroid.feature.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ridhaaf.zweilinguaandroid.feature.data.models.Meaning
import com.ridhaaf.zweilinguaandroid.feature.data.models.WordInfo

@Entity
data class WordInfoEntity(
    val meanings: List<Meaning>,
    val phonetic: String? = "",
    val word: String,
    @PrimaryKey val id: Int? = null,
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings,
            phonetic = phonetic,
            word = word,
        )
    }
}
