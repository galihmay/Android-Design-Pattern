package com.galihmayangga.android.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
        val title: String = "",
        val url: String = "",
        val urlToImage: String = "",
        val tipe: String = "",
        val publishedAt: String = ""
) : Parcelable