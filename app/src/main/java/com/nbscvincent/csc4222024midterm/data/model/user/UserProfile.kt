package com.nbscvincent.csc4222024midterm.data.model.user


import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class UserProfile(
    val users: List<User>,
    val total: Int,
    val skip: Int,
    val limit: Int
)