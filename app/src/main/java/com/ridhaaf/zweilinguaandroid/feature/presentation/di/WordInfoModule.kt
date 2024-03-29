package com.ridhaaf.zweilinguaandroid.feature.presentation.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.ridhaaf.zweilinguaandroid.feature.data.local.Converters
import com.ridhaaf.zweilinguaandroid.feature.data.local.WordInfoDatabase
import com.ridhaaf.zweilinguaandroid.feature.data.remote.DictionaryApi
import com.ridhaaf.zweilinguaandroid.feature.data.repositories.WordInfoRepositoryImpl
import com.ridhaaf.zweilinguaandroid.feature.data.utils.GsonParser
import com.ridhaaf.zweilinguaandroid.feature.domain.repositories.WordInfoRepository
import com.ridhaaf.zweilinguaandroid.feature.domain.use_cases.GetWordInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {
    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(
        repository: WordInfoRepository,
    ): GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: WordInfoDatabase,
        api: DictionaryApi,
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(
        app: Application,
    ): WordInfoDatabase {
        return Room.databaseBuilder(
            app,
            WordInfoDatabase::class.java,
            "word_db",
        ).addTypeConverter(Converters(GsonParser(Gson()))).build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder().baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(DictionaryApi::class.java)
    }
}