package com.ridhaaf.zweilinguaandroid.feature.data.remote.dto

import com.ridhaaf.zweilinguaandroid.feature.data.local.entities.WordInfoEntity

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val word: String,
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            phonetic = phonetic,
            word = word,
        )
    }
}