package com.example.usersapp.presentation.ui.viewmodel

import com.example.usersapp.domain.model.User

sealed class UsersUiState {
    object Loading : UsersUiState()
    data class Success(val users: List<User>) : UsersUiState()
    data class Error(val message: String) : UsersUiState()
}