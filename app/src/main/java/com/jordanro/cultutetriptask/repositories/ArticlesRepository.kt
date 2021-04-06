package com.jordanro.cultutetriptask.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.jordanro.cultutetriptask.data.entities.ArticleList
import com.jordanro.cultutetriptask.data.remote.CultureTripApi
import com.jordanro.cultutetriptask.data.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ArticlesRepository @Inject constructor(
    private val remoteApi: CultureTripApi,
    private val dispatcher: CoroutineDispatcher){

    fun loadArticles(): LiveData<Resource<ArticleList>> =
        liveData(dispatcher) {
            emit(Resource.loading())
            emit(remoteApi.loadArticles())

        }

}