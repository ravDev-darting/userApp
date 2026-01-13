package com.example.usersapp.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usersapp.domain.model.User
import com.example.usersapp.domain.model.repository.Result
import com.example.usersapp.domain.model.usecase.GetUsersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UsersViewModel(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {

    private val _state = MutableStateFlow<UsersUiState>(UsersUiState.Loading)
    val state: StateFlow<UsersUiState> = _state.asStateFlow()

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            getUsersUseCase().collect { result ->
                when (result) {
                    is Result.Loading -> {
                        _state.value = UsersUiState.Loading
                    }
                    is Result.Success -> {
                        _state.value = UsersUiState.Success(result.data)
                    }
                    is Result.Error -> {
                        _state.value = UsersUiState.Error(result.message)
                    }
                }
            }
        }
    }
}