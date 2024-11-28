package com.rentSystem.project;

import java.util.List;
import java.util.UUID;

public interface IUserManager {
    UUID addUser(User user);
    User getUserByID(UUID userID);
    List<User> getAllUsers();
}

