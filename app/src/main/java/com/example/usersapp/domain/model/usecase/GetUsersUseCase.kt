package com.example.usersapp.domain.model.usecase

import com.example.usersapp.domain.model.User
import com.example.usersapp.domain.model.repository.Result
import com.example.usersapp.domain.model.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUsersUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(): Flow<Result<List<User>>> {
        return repository.getUsers()
    }
}