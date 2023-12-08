package com.ridhaaf.zweilinguaandroid.feature.presentation.word_info

import com.ridhaaf.zweilinguaandroid.feature.data.models.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false,
)
