package com.ridhaaf.zweilinguaandroid.feature.data.repositories

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.ridhaaf.zweilinguaandroid.core.utils.Resource
import com.ridhaaf.zweilinguaandroid.feature.data.local.WordInfoDao
import com.ridhaaf.zweilinguaandroid.feature.data.models.WordInfo
import com.ridhaaf.zweilinguaandroid.feature.data.remote.DictionaryApi
import com.ridhaaf.zweilinguaandroid.feature.domain.repositories.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao,
) : WordInfoRepository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordInfos = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfos.map { it.word })
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    "Oops, something went wrong!",
                    data = wordInfos,
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    "Couldn't reach server. Check your internet connection.",
                    data = wordInfos,
                )
            )
        }

        val newWordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfos))
    }
}