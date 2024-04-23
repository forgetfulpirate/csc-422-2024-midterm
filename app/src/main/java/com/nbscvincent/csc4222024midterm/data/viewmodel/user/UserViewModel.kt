package com.nbscvincent.csc4222024midterm.data.viewmodel.user

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.nbscvincent.csc4222024midterm.data.model.user.User
import com.nbscvincent.csc4222024midterm.data.model.user.UserLogIn
import com.nbscvincent.csc4222024midterm.data.model.user.UserLoggedIn
import com.nbscvincent.csc4222024midterm.data.repository.user.OfflineUserRepository
import com.nbscvincent.csc4222024midterm.data.repository.user.OnlineUserRepository

class UserViewModel(
    private val onlineUserRepository: OnlineUserRepository,
    private val offlineUserRepository: OfflineUserRepository
) : ViewModel() {
    var userList by mutableStateOf<List<User>>(emptyList())

    suspend fun getUsers(user: List<User>) {
        try {
            val users = onlineUserRepository.getUsers()
            userList = users
            Log.i("", "userList $userList")
        } catch (e: Exception) {
            Log.e("", "Failed to fetch users: ${e.message}", e)
        }
    }

    suspend fun validateUser(username: String, password: String): User? {
        return try {
            val user = userRepository.getUserByUsernameAndPassword(username, password)
            user?.let {
                // Set the logged-in user as the LoggedInUser holder
                UserLoggedIn.setLoggedInUser(UserLogIn(it.id, it.firstName, it.lastName,it.gender, it.username, it.password, it.email, it.phone, it.image))
                // Save user data to local database
                offlineUserRepository.saveUserToLocalDatabase(it)
            }
            user
        } catch (e: Exception) {
            Log.e("", "Failed to validate user: ${e.message}", e)
            null
        }
    }
}