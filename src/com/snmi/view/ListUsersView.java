package com.snmi.view;

import com.snmi.model.User;
import java.util.List;

/**
 * List users view
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class ListUsersView {

    /**
     * Constants
     */
    private static final String PAGE_NAME = "---SHOW ALL VIEW---";

    /**
     * Show view
     * @param users take users list
     */
    public void showView(List<User> users) {
        System.out.println();
        System.out.println(PAGE_NAME);

        users.forEach(u -> System.out.println(u.getName()));

        System.out.println(PAGE_NAME);
        System.out.println();
    }

}
