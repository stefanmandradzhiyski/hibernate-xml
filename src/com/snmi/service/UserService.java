package com.snmi.service;

import com.snmi.enums.UpdateTypes;
import com.snmi.model.User;
import java.util.List;

/**
 * User service interface
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public interface UserService {

    User createUser(User user);
    List<User> readAllUsers();
    List<User> pagingAllUsers(int start, int show);
    User readUserById(int id);
    List<User> readUserByName(String name);
    User updateUser(int id, String name, int goal, int total, UpdateTypes updateTypes);
    void deleteUser(int id);

}
