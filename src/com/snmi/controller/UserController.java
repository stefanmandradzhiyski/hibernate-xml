package com.snmi.controller;

import com.snmi.enums.UpdateTypes;
import com.snmi.model.User;
import com.snmi.service.UserServiceImpl;
import com.snmi.service.UserService;
import java.util.List;
import com.snmi.view.*;

/**
 * User controller which delegate with user service and views
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class UserController {

    /**
     * Constants
     */
    private static final String NEXT_ACTION = "What next (C/RALL/RBYID/RBYNAME/PR/U/D/Q): ";
    private static final String MISSING_USER = "User with that %s doesn't exist!";
    private static final String USER_COMPLETE = "The user have been %s successfully!";
    private static final String INVALID_USER = "Invalid user's data. Try again with new values!";

    /**
     * All object variables with which the controller works
     */
    private Dispatcher dispatcher;
    private UserService userServiceImpl;
    private CompleteView completeView;
    private ErrorView errorView;

    /**
     * Custom constructor
     * @param dispatcher take the dispatcher and instance all needed objects
     */
    public UserController(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.userServiceImpl = new UserServiceImpl();
        completeView = new CompleteView();
        errorView = new ErrorView();
    }

    /**
     * Create user method
     * @param view take the needed view
     */
    public void createUser(CreateUserView view) {
        User user = view.showView();
        user = userServiceImpl.createUser(user);
        if (user != null) {
            completeView.showView(String.format(USER_COMPLETE, "created"));
        } else {
            errorView.showView(INVALID_USER);
        }

        dispatcher.showView(NEXT_ACTION);
    }

    /**
     * Read all users method
     * @param view take the needed view
     */
    public void readAllUsers(ListUsersView view) {
        List<User> users = userServiceImpl.readAllUsers();
        view.showView(users);

        dispatcher.showView(NEXT_ACTION);
    }

    /**
     * Read specific user by id
     * @param view take the needed view
     */
    public void readUserById(SpecificUserView view) {
        int id = view.getIdFromView();
        User user = userServiceImpl.readUserById(id);
        if (user != null) {
            view.showIdView(user);
        } else {
            errorView.showView(String.format(MISSING_USER, "ID"));
        }

        dispatcher.showView(NEXT_ACTION);
    }

    /**
     * Read specific user by name
     * @param view take the needed view
     */
    public void readUserByName(SpecificUserView view) {
        String name = view.getNameFromView();
        List<User> users = userServiceImpl.readUserByName(name);
        if (users.size() > 0) {
            view.showNameView(users);
        } else {
            errorView.showView(String.format(MISSING_USER, "name"));
        }

        dispatcher.showView(NEXT_ACTION);
    }

    /**
     * Separates all users data on pages
     * @param view take the needed view
     */
    public void pagingAllUsers(PageReadingView view) {
        int start = 0;
        int show = 2;
        int page = 1;
        boolean next = true;

        while (next) {
            List<User> users = userServiceImpl.pagingAllUsers(start, show);
            view.showView(users, page);
            start += show;
            page++;

            if (users.size() > 1) {
                next = view.showMore();
            } else {
                next = false;
            }
        }

        dispatcher.showView(NEXT_ACTION);
    }

    /**
     * Update specific user by id
     * @param view take the needed view
     */
    public void updateUser(UpdateUserView view) {
        int id = view.getUserId();
        User user = userServiceImpl.readUserById(id);
        if (user != null) {
            UpdateTypes updateTypes = view.chooseUpdateType();

            String name = null;
            int goal = 0;
            int total = 0;

            switch (updateTypes) {
                case NAME:
                    name = view.getUserNameView();
                    break;
                case GOAL:
                    goal = view.getUserProteinView(updateTypes);
                    break;
                case TOTAL:
                    total = view.getUserProteinView(updateTypes);
                    break;
            }

            userServiceImpl.updateUser(id, name, goal, total, updateTypes);
            completeView.showView(String.format(USER_COMPLETE, "updated"));
        } else {
            errorView.showView(String.format(MISSING_USER, "ID"));
        }

        dispatcher.showView(NEXT_ACTION);
    }

    /**
     * Delete specific user by id
     * @param view take the needed view
     */
    public void deleteUser(DeleteUserView view) {
        int id = view.getUserIdFromView();
        User user = userServiceImpl.readUserById(id);
        if (user != null) {
            userServiceImpl.deleteUser(id);
            completeView.showView(String.format(USER_COMPLETE, "deleted"));
        } else {
            errorView.showView(String.format(MISSING_USER, "ID"));
        }

        dispatcher.showView(NEXT_ACTION);
    }

}
