package com.nbscvincent.csc4222024midterm.data.model.user

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.google.gson.Gson


object UserLoggedIn {

    private const val PREFS_NAME = "MyPrefs"
    private const val USER_KEY = "user"

    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()

    private val _userLoggedIn = MutableStateFlow<UserLogIn?>(null)
    val userloggedIn = _userLoggedIn.asStateFlow()

fun init(context: Context) {
    sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    val savedUserString = sharedPreferences.getString(USER_KEY, null)
    savedUserString?.let{
        _userLoggedIn.value = gson.fromJson(it, UserLogIn::class.java)
    }
}
    fun setLoggedInUser(user: UserLogIn) {
        if (_userLoggedIn.value != user) {
            _userLoggedIn.value = user
            saveUserToPrefs(user)

            // Log the inserted LoggedInUser
            Log.i("UserLoggedIn", "Inserted UserLogIn: $user")
        }
    }

    fun clearLoggedInUser() {
        _userLoggedIn.value = null
        clearUserFromPrefs()
        Log.i("UserLoggedIn", "Logged Out: ${_userLoggedIn.value}")
    }

    fun getUsers(): UserLogIn? {
        return _userLoggedIn.value
    }

    fun isLoggedIn(): Boolean {
        return _userLoggedIn.value != null
    }

    private fun saveUserToPrefs(user: UserLogIn) {
        val editor = sharedPreferences.edit()
        val userString = gson.toJson(user)
        editor.putString(USER_KEY, userString)
        editor.apply()
    }

    private fun clearUserFromPrefs() {
        val editor = sharedPreferences.edit()
        editor.remove(USER_KEY)
        editor.apply()
    }
}