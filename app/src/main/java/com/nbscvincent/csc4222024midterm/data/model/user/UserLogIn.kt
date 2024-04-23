package com.nbscvincent.csc4222024midterm.data.model.user

data class UserLogIn(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val username: String,
    val password:String,
    val email: String,
    val phone: String,
    val image: String,
)