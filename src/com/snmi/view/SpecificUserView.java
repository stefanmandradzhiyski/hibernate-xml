package com.snmi.view;

import com.snmi.model.User;
import com.snmi.utils.KeyboardUtil;
import java.util.List;

/**
 * Specific user view
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class SpecificUserView {

    /**
     * Constants
     */
    private static final String PAGE_NAME = "---SHOW SPECIFIC VIEW---";
    private static final String NAME_MESSAGE = "Input the user name: ";
    private static final String ID_MESSAGE = "Input valid id: ";
    private static final String ID_MESSAGE_ERROR = "Invalid id. The ID must be a number!";
    private static final String SHOW_USER = "%s protein total is %d. His protein goal is %d.";

    /**
     * Get the name from view
     * @return the name
     */
    public String getNameFromView() {
        System.out.println();
        System.out.println(PAGE_NAME);

        return KeyboardUtil.getName(NAME_MESSAGE);
    }

    /**
     * Show the users founded by name
     * @param users take the users
     */
    public void showNameView(List<User> users) {
        for (User user : users) {
            System.out.println(String.format(SHOW_USER,
                    user.getName(), user.getProteinData().getTotal(), user.getProteinData().getGoal()));
        }

        System.out.println(PAGE_NAME);
        System.out.println();
    }

    /**
     * Get the user id
     * @return the id
     */
    public int getIdFromView() {
        System.out.println();
        System.out.println(PAGE_NAME);

        return KeyboardUtil.getNumber(ID_MESSAGE, ID_MESSAGE_ERROR);
    }

    /**
     * Show user founded by id
     * @param user take the user
     */
    public void showIdView(User user) {
        System.out.println(String.format(SHOW_USER,
                user.getName(), user.getProteinData().getTotal(), user.getProteinData().getGoal()));

        System.out.println(PAGE_NAME);
        System.out.println();
    }

}
