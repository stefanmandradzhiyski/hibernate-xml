package com.snmi.service;

import com.snmi.enums.UpdateTypes;
import com.snmi.repository.UserRepositoryImpl;
import com.snmi.model.User;
import com.snmi.utils.ValidatorUtil;
import java.util.List;

/**
 * User service implementation which delegate with the repository
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class UserServiceImpl implements UserService{

    /**
     * User repository implementation object
     */
    private UserRepositoryImpl userRepository;

    /**
     * Default constructor which instantiation the user repository object
     */
    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    /**
     * Create user method
     * @param user take the user
     * @return the user
     */
    @Override
    public User createUser(User user) {
        if (isUserValid(user)) {
            return userRepository.createUser(user);
        }

        return null;
    }

    /**
     * Read all users
     * @return users list
     */
    @Override
    public List<User> readAllUsers() {
        return userRepository.readAllUsers();
    }

    /**
     * Read users on pages
     * @param start the start point
     * @param show take how many records you want to show
     * @return users list
     */
    @Override
    public List<User> pagingAllUsers(int start, int show) {
        return userRepository.pagingAllUsers(start, show);
    }

    /**
     * Read specific user by id
     * @param id take the id
     * @return the founded user
     */
    @Override
    public User readUserById(int id) {
        return userRepository.readUserById(id);
    }

    /**
     * Read specific user by name
     * @param name take the name
     * @return users list with these names
     */
    @Override
    public List<User> readUserByName(String name) {
        return userRepository.readUserByName(name);
    }

    /**
     * Update specific user by id
     * @param id take the id
     * @param name take the name
     * @param goal take the goal
     * @param total take the total
     * @param updateTypes take update type
     * @return loaded user
     */
    @Override
    public User updateUser(int id, String name, int goal, int total, UpdateTypes updateTypes) {
        return userRepository.updateUser(id, name, goal, total, updateTypes);
    }

    /**
     * Delete specific user by id
     * @param id take the id
     */
    @Override
    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

    /**
     * Check if the user is valid
     * @param user take the user
     * @return boolean result
     */
    private boolean isUserValid(User user) {
        return  ValidatorUtil.isNameValid(user.getName()) &&
                ValidatorUtil.isProteinValid(user.getProteinData().getGoal()) &&
                ValidatorUtil.isProteinValid(user.getProteinData().getTotal());
    }

}
