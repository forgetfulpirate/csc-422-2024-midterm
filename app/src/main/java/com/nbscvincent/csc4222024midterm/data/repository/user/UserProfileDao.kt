package com.nbscvincent.csc4222024midterm.data.repository.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nbscvincent.csc4222024midterm.data.model.user.User

@Dao
interface UserProfileDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User.Companion)
    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("Select * FROM User")
    suspend fun getAllUsers() : List<User>

    @Query("Select * FROM User WHERE id = :id")
    suspend fun getUserById(id: Int) : User
}