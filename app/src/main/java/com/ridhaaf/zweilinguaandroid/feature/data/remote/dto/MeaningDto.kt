package com.ridhaaf.zweilinguaandroid.feature.data.remote.dto

import com.ridhaaf.zweilinguaandroid.feature.data.models.Meaning

data class MeaningDto(
    val antonyms: List<Any>,
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String,
    val synonyms: List<String>,
) {
    fun toMeaning(): Meaning {
        return Meaning(
            antonyms = antonyms,
            definitions = definitions.map { it.toDefinition() },
            partOfSpeech = partOfSpeech,
            synonyms = synonyms,
        )
    }
}