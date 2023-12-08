package com.ridhaaf.zweilinguaandroid.feature.domain.repositories

import com.ridhaaf.zweilinguaandroid.core.utils.Resource
import com.ridhaaf.zweilinguaandroid.feature.data.models.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}