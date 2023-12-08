package com.ridhaaf.zweilinguaandroid.feature.data.models

data class Meaning(
    val antonyms: List<Any>,
    val definitions: List<Definition>,
    val partOfSpeech: String,
    val synonyms: List<String>,
)
