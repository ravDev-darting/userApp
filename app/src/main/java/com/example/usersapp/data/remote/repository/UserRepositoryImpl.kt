package com.example.usersapp.data.remote.repository

import com.example.usersapp.data.remote.ApiService
import com.example.usersapp.data.remote.mapper.toDomain
import com.example.usersapp.domain.model.User
import com.example.usersapp.domain.model.repository.Result
import com.example.usersapp.domain.model.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class UserRepositoryImpl(
    private val apiService: ApiService  // Add constructor parameter
) : UserRepository {

    override suspend fun getUsers(): Flow<Result<List<User>>> = flow {
        emit(Result.loading())
        try {
            val response = apiService.getUsers()  // Now using injected apiService
            if (response.isSuccessful) {
                val userDtos = response.body() ?: emptyList()
                val users = userDtos.map { it.toDomain() }
                emit(Result.success(users))
            } else {
                emit(Result.error("Failed to fetch users: ${response.code()}"))
            }
        } catch (e: IOException) {
            emit(Result.error("Network error: ${e.message}"))
        } catch (e: HttpException) {
            emit(Result.error("HTTP error: ${e.message}"))
        } catch (e: Exception) {
            emit(Result.error("Unexpected error: ${e.message}"))
        }
    }
}