package com.jordanro.cultutetriptask.data.remote

import com.jordanro.cultutetriptask.data.utils.BaseDataSource
import javax.inject.Inject

class CultureTripApiImpl @Inject constructor(
    private val remoteDataSource: CultureTripService
) : BaseDataSource(), CultureTripApi{

    override suspend fun loadArticles()= getResult{remoteDataSource.loadArticles()}
}