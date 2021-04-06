package com.jordanro.cultutetriptask.data.remote

import com.jordanro.cultutetriptask.data.entities.Article
import com.jordanro.cultutetriptask.data.entities.ArticleList
import com.jordanro.cultutetriptask.data.utils.Resource

interface CultureTripApi {

    suspend fun loadArticles()  : Resource<ArticleList>

}