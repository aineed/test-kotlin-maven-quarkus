package domain

import jakarta.validation.constraints.Email

data class Profile(
        val username: String,
        val firstname: String,
        val lastname: String,
        val email: String,
        val phoneNumber: Number
)
