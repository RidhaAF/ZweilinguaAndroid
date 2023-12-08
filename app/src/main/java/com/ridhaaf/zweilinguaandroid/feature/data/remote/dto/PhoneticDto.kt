package com.ridhaaf.zweilinguaandroid.feature.data.remote.dto

import com.ridhaaf.zweilinguaandroid.feature.data.models.Phonetic

data class PhoneticDto(
    val audio: String,
    val license: LicenseDto,
    val sourceUrl: String,
    val text: String,
) {
    fun toPhonetic(): Phonetic {
        return Phonetic(
            audio = audio,
            license = license.toLicense(),
            sourceUrl = sourceUrl,
            text = text,
        )
    }
}