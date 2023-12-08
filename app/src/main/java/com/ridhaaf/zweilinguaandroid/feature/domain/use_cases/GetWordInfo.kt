package com.ridhaaf.zweilinguaandroid.feature.domain.use_cases

import com.ridhaaf.zweilinguaandroid.core.utils.Resource
import com.ridhaaf.zweilinguaandroid.feature.data.models.WordInfo
import com.ridhaaf.zweilinguaandroid.feature.domain.repositories.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private var repository: WordInfoRepository
) {
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return flow {  }
        } else {
            return repository.getWordInfo(word)
        }
    }
}