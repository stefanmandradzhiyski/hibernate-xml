package com.snmi.view;

import com.snmi.utils.KeyboardUtil;

/**
 * Delete view
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class DeleteUserView {

    /**
     * Constants
     */
    private static final String PAGE_NAME = "---DELETE VIEW---";
    private static final String PAGE_MESSAGE = "Input user id which you want to delete: ";
    private static final String PAGE_INVALID_MESSAGE = "Invalid ID. The ID must be a number!";

    /**
     * Get the user id from view
     * @return the id
     */
    public int getUserIdFromView() {
        System.out.println();
        System.out.println(PAGE_NAME);
        return KeyboardUtil.getNumber(PAGE_MESSAGE, PAGE_INVALID_MESSAGE);
    }

}
