package com.nbscvincent.csc4222024midterm.data.repository.user

import com.nbscvincent.csc4222024midterm.data.model.user.User
interface UserRepository{
    suspend fun getUsers(): List<User>
    suspend fun getUserById(id:Int): User

    suspend fun addUser(user: User):User

    suspend fun  updateUser(user: User): User

    suspend fun deleteUser(id: Int): Boolean

    suspend fun getUserByUsernameAndPassword(username: String, password: String): User?
}