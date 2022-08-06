package com.meuapp.listrepositoriesapp.data.repository

import android.util.Log
import com.meuapp.listrepositoriesapp.data.datasource.api.RepoEntity
import com.meuapp.listrepositoriesapp.data.datasource.api.getRepo
import com.meuapp.listrepositoriesapp.domain.model.Repo
import com.meuapp.listrepositoriesapp.domain.repository.RepoDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.lang.Exception


interface RepoApi {

    @GET("users/MatheusAraujoPro/repos")
    suspend fun getRepos(): List<RepoEntity>

    companion object {
        var repoAPi: RepoApi? = null
        fun getInstance(): RepoApi {
            if (repoAPi == null) {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)

                val client = OkHttpClient().newBuilder()
                client.addInterceptor(logging)

                repoAPi = Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client.build())
                    .build().create(RepoApi::class.java)
            }
            Log.d("Esse aqui é o RepoAPI", "RepoAPi: ${repoAPi}")

            return repoAPi!!
        }
    }
}

class RepoApiImpl : RepoDataSource {
    override suspend fun getRepos(): List<Repo> {
        return withContext(Dispatchers.IO) {
            RepoApi.getInstance().getRepos().map { repo -> repo.getRepo() }
        }
    }
}
