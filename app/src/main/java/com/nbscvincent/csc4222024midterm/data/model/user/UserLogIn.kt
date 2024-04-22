package com.nbscvincent.csc4222024midterm.data.model.user

data class UserLogIn(
    val id: Int,
    val username: String,
    val email: String,
    val password:String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    val phone: String,
)