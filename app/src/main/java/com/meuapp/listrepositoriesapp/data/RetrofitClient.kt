package com.meuapp.listrepositoriesapp.data

import com.meuapp.listrepositoriesapp.data.services.ReposWebService
import com.meuapp.listrepositoriesapp.domain.constants.RepoConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideRetrofit(): Retrofit {
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = OkHttpClient().newBuilder()
    client.addInterceptor(logging)

    return Retrofit.Builder()
        .baseUrl(RepoConstants.WebConstants.GITHUB_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client.build())
        .build()
}

fun provideGitHubWebService(retrofit: Retrofit): ReposWebService =
    retrofit.create(ReposWebService::class.java)