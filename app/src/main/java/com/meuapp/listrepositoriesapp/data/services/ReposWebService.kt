package com.meuapp.listrepositoriesapp.data.services

import com.meuapp.listrepositoriesapp.data.models.RepoEntity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ReposWebService {

    @GET("users/MatheusAraujoPro/repos")
    suspend fun getRepos(): List<RepoEntity>

    companion object {
        var repoWebService: ReposWebService? = null
        fun getInstance(): ReposWebService {
            if (repoWebService == null) {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)

                val client = OkHttpClient().newBuilder()
                client.addInterceptor(logging)

                repoWebService = Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client.build())
                    .build().create(ReposWebService::class.java)
            }
            return repoWebService!!
        }
    }
}