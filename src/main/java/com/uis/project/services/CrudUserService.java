package com.uis.project.services;

import com.uis.project.persistences.models.User;

public interface CrudUserService {

    User createUser(User user);
    void deleteUser(Long userId);
    User findUserById(Long userId);
    User findUserByEmail(String email);

}
