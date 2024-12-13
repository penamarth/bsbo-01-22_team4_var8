package com.rentSystem.project

import java.util.*

class UserManager : IUserManager {
    private val users: MutableList<User> = mutableListOf()

    override fun addUser(user_new: UserData): UUID {
        val user = User(
            FirstName = user_new.FirstName,
            LastName = user_new.LastName,
            Email = user_new.Email,
            Phone = user_new.Phone,
            Password = user_new.Password
        )
        users.add(user)
        println("User added: $user")
        return user.ID
    }

    override fun getUserByID(userID: UUID): User {
        val user = users.find { it.ID == userID }
        return if (user != null) {
            println("Retrieved User: $user")
            user
        } else {
            println("User with ID $userID not found")
            throw UserNotFoundException()
        }
    }

    override fun getAllUsers(): List<User> {
        println("Retrieving all users. Total users: ${users.size}")
        return users.toList()
    }

    override fun updateUser(userID: UUID, updatedUser: User) {
        val index = users.indexOfFirst { it.ID == userID }
        if (index != -1) {
            users[index] = updatedUser
            println("User with ID $userID updated to: $updatedUser")
        } else {
            println("Cannot update. User with ID $userID not found")
            throw UserNotFoundException()
        }
    }

    override fun deleteUser(userID: UUID) {
        val removed = users.removeIf { it.ID == userID }
        if (removed) {
            println("User with ID $userID deleted successfully")
        } else {
            println("Cannot delete. User with ID $userID not found")
            throw UserNotFoundException()
        }
    }
}
