package com.kotlin.newsapplication.repository

import com.kotlin.newsapplication.api.RetrofitInstance
import com.kotlin.newsapplication.db.ArticleDatabase
import com.kotlin.newsapplication.models.Article

class NewsRepository(val db: ArticleDatabase) {
    suspend fun getHeadline(country: String, page: Int) =
        RetrofitInstance.api.getHeadline(country, page)

    suspend fun searchNews(searchQuery: String, page: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, page)

    suspend fun upsert(article: Article) =
        db.getArticleDao().upsert(article)

    fun getFavoriteNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) =
        db.getArticleDao().deleteArticle(article)
}