package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.data.model.Repo
import br.com.dio.app.repositories.data.services.GithubService
import kotlinx.coroutines.flow.flow

class RepoRepositoryImp(private val service: GithubService): Repository {
    override suspend fun listRepositories(user: String) = flow<List<Repo>> {
        val repoList = service.listRepositories(user)
        emit(repoList)
    }
}