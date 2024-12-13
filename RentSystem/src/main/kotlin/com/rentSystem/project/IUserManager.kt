package com.rentSystem.project

import java.util.*

interface IUserManager {
    fun addUser(user_new: UserData): UUID
    fun getUserByID(userID: UUID): User
    fun getAllUsers(): List<User>
    fun updateUser(userID: UUID, updatedUser: User)
    fun deleteUser(userID: UUID)
}