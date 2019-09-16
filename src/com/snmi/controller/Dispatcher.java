package com.snmi.controller;

import com.snmi.enums.Actions;
import com.snmi.view.*;

/**
 * Dispatcher which point to view-controller on entry action
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class Dispatcher {

    /**
     * Constants
     */
    private static final String INVALID_ACTION = "Invalid action. Please choose from (C/RALL/RBYID/RBYNAME/PR/U/D/Q): ";

    /**
     * Objects which will navigate
     */
    private MainView view;
    private UserController userController;

    /**
     * Custom constructor
     * @param view take the main view
     */
    public Dispatcher(MainView view) {
        this.view = view;
        userController = new UserController(this);
    }

    /**
     * Control the whole program
     * @param question take the entry question message
     */
    public void showView(String question) {
        Actions action = view.showView(question);
        switch (action) {
            case CREATE:
                CreateUserView createView = new CreateUserView();
                userController.createUser(createView);
                break;
            case READ_ALL:
                ListUsersView listView = new ListUsersView();
                userController.readAllUsers(listView);
                break;
            case READ_BY_ID:
                SpecificUserView specificIdView = new SpecificUserView();
                userController.readUserById(specificIdView);
                break;
            case READ_BY_NAME:
                SpecificUserView specificNameView = new SpecificUserView();
                userController.readUserByName(specificNameView);
                break;
            case PAGE_READING:
                PageReadingView pageReadingView = new PageReadingView();
                userController.pagingAllUsers(pageReadingView);
                break;
            case UPDATE:
                UpdateUserView updateView = new UpdateUserView();
                userController.updateUser(updateView);
                break;
            case DELETE:
                DeleteUserView deleteView = new DeleteUserView();
                userController.deleteUser(deleteView);
                break;
            case QUIT:
                System.exit(0);
                break;
            case INVALID:
                showView(INVALID_ACTION);
                break;
        }
    }

}
