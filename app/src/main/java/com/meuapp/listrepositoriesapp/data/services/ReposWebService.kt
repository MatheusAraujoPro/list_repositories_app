package com.meuapp.listrepositoriesapp.data.services

import com.meuapp.listrepositoriesapp.data.models.RepoEntity
import com.meuapp.listrepositoriesapp.domain.constants.RepoConstants
import retrofit2.http.GET

interface ReposWebService {
    @GET(RepoConstants.WebConstants.GITHUB_URL_USER_REPO)
    suspend fun getRepos(): List<RepoEntity>
}