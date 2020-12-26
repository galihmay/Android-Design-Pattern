package com.galihmayangga.android.data.model

data class NewsList(
        val data: List<News> = arrayListOf(),
        val status: String ,
        val totalResults: Int = 0
)
