package com.nbscvincent.csc4222024midterm.data.repository.user

import com.nbscvincent.csc4222024midterm.data.model.user.User

class OfflineUserRepository(private val userProfileDao: UserProfileDao){
    suspend fun saveUserToLocalDatabase(user:User){
        userProfileDao.insert(User)
    }
}