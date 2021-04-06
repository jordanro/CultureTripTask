package com.jordanro.cultutetriptask.data.remote

import com.jordanro.cultutetriptask.data.entities.ArticleList
import retrofit2.Response
import retrofit2.http.GET

interface CultureTripService {

    @GET("home-assignment/response.json")
    suspend fun loadArticles() : Response<ArticleList>
}