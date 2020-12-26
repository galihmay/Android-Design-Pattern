package com.galihmayangga.android.data.repository

import android.app.Notification
import com.galihmayangga.android.data.model.ActionState
import com.galihmayangga.android.data.model.News
import com.galihmayangga.android.data.remote.NewsService
import com.galihmayangga.android.data.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception

class NewsRepository {
    private val newsService: NewsService by lazy { RetrofitApi.newsService() }
suspend fun listNews()  : ActionState<List<News>> {
    return try {
        val list = newsService.listNews().await()
        ActionState(list.data)
    } catch (e: Exception) {
        ActionState(message = e.message, isSuccess = false)
    }
}
    suspend fun detailNews(url: String): ActionState<News> {
        return try {
            val list = newsService.detailNews(url).await()
            ActionState(list.data.first())
        }catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }
    suspend fun  searchNews(query: String) : ActionState<List<News>> {
      return  try {
            val list = newsService.searchNews(query).await()
            ActionState(list.data)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }
}