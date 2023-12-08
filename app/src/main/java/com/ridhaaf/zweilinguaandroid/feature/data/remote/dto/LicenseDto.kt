package com.ridhaaf.zweilinguaandroid.feature.data.remote.dto

import com.ridhaaf.zweilinguaandroid.feature.data.models.License

data class LicenseDto(
    val name: String,
    val url: String,
) {
    fun toLicense(): License {
        return License(
            name = name,
            url = url,
        )
    }
}