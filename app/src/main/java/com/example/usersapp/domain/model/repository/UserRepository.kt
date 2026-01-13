package com.example.usersapp.domain.model.repository  // Note: should be domain.repository, not domain.model.repository

import com.example.usersapp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUsers(): Flow<Result<List<User>>>  // This should be YOUR custom Result
}