package com.rentSystem.project

import java.util.*

class UserManager : IUserManager {
    private val users = mutableListOf<User>()

    override fun addUser(user: User): UUID {
        users.add(user)
        return user.id
    }

    override fun getUserByID(userID: UUID): User? {
        return users.find { it.id == userID }
    }

    override fun getAllUsers(): List<User> {
        return users
    }
}
