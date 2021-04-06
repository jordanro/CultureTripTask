package com.jordanro.cultutetriptask.di

import android.content.Context
import com.jordanro.cultutetriptask.data.remote.CultureTripApi
import com.jordanro.cultutetriptask.data.remote.CultureTripApiImpl
import com.jordanro.cultutetriptask.data.remote.CultureTripService
import com.jordanro.cultutetriptask.repositories.ArticlesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    private val BASE_URL = "https://cdn.theculturetrip.com/"

    @Singleton
    @Provides
    fun provideHttpClient(@ApplicationContext appContext: Context) : OkHttpClient =
        OkHttpClient().newBuilder()
            .cache(Cache(appContext.cacheDir, 10 * 1024 * 1024.toLong()))
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient) : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideRemoteService(retrofit: Retrofit) : CultureTripService = retrofit.create(CultureTripService::class.java)


    @Singleton
    @Provides
    fun provideCultureTripApi(remoteService :CultureTripService) : CultureTripApi = CultureTripApiImpl(remoteService)

    @Singleton
    @Provides
    fun provideRepository(remoteApi: CultureTripApi) : ArticlesRepository =
        ArticlesRepository(remoteApi, Dispatchers.IO)

}