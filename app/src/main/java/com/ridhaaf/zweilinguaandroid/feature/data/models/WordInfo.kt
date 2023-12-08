package com.ridhaaf.zweilinguaandroid.feature.data.models

data class WordInfo(
    val meanings: List<Meaning>,
    val phonetic: String? = "",
    val word: String,
)
