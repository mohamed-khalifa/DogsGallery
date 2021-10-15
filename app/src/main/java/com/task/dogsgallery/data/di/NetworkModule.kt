package com.task.dogsgallery.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.task.dogsgallery.data.constants.NetworkConstants.BASE_URL
import com.task.dogsgallery.data.remote.datasource.RemoteDataSource
import com.task.dogsgallery.data.remote.datasource.RemoteDataSourceImpl
import com.task.dogsgallery.data.remote.service.ApiService
import com.task.dogsgallery.data.repository.DogsRepository
import com.task.dogsgallery.domain.mapper.DogDomainMapper
import com.task.dogsgallery.domain.repository.DogsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


    @Provides
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }


    @Singleton
    @Provides
    fun provideDogsRepository(
        remoteDataSource: RemoteDataSource
    ): DogsRepository {
        return DogsRepositoryImpl(remoteDataSource, DogDomainMapper())
    }
}