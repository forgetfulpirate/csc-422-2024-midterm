package com.nbscvincent.csc4222024midterm.data.model.user

import kotlinx.serialization.Serializable

@Serializable
data class Credentials (
    val username: String,
    val password: String
)