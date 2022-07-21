package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.data.model.Repo
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun listRepositories(user: String) : Flow<List<Repo>>
}