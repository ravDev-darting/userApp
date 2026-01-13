package com.example.usersapp.data.remote.mapper

import com.example.usersapp.data.remote.model.UserDto
import com.example.usersapp.domain.model.User

fun UserDto.toDomain(): User {
    return User(
        id = id,
        name = name,
        username = "",  // Provide default if missing
        email = email,
        phone = phone ?: "",  // Handle nullable
        website = website ?: "",
        address = "",  // Simple address or combine fields
        company = ""   // Simple company name
    )
}