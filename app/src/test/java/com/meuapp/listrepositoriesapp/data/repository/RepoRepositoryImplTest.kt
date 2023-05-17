package com.meuapp.listrepositoriesapp.data.repository

import com.meuapp.listrepositoriesapp.domain.model.Repo
import com.meuapp.listrepositoriesapp.domain.datasource.RepoDataSource
import com.meuapp.listrepositoriesapp.domain.repository.RepoRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

class RepoRepositoryImplTest {

    @Mock
    private lateinit var dataSource: RepoDataSource
    private lateinit var repository: RepoRepository

    val DUMMY_REPO = Repo(0, "DUMMY", "DUMMY DESCRIPTION", "KOTLIN")
    val DUMMY_REPO_LIST = listOf(DUMMY_REPO)
    val DUMMY_REPO_EMPTY_LIST = null

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        repository = RepoRepositoryImpl(dataSource = dataSource)
    }

    @Test
    fun `getRepos must return list Repo when has a success`() {
        stubGetListReposSuccess()
        var listRepos: List<Repo>? = null

        runBlocking {
            listRepos = repository.getRepos()
        }
        assertEquals(DUMMY_REPO_LIST, listRepos)
    }

    private fun stubGetListReposSuccess() {
        runBlocking {
            whenever(repository.getRepos()).thenReturn(
                DUMMY_REPO_LIST
            )
        }
    }

    @Test
    fun `getRepos must return list Repo when has a error`(){
        stubGetListReposError()
        var listRepo: List<Repo>? = null
        runBlocking {
            listRepo = repository.getRepos()
        }
        assertEquals(listRepo, DUMMY_REPO_EMPTY_LIST)

    }

    private fun stubGetListReposError(){
        runBlocking {
            whenever(repository.getRepos()).thenReturn(
                DUMMY_REPO_EMPTY_LIST
            )
        }
    }
}