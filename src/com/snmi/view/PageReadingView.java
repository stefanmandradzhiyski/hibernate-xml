package com.snmi.view;

import com.snmi.model.User;
import com.snmi.utils.KeyboardUtil;
import java.util.List;

/**
 * Page reading view (All users on pages)
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class PageReadingView {

    /**
     * Constants
     */
    private static final String PAGE_NAME = "---PAGE %d READING VIEW---";
    private static final String CONTINUE_MESSAGE = "Continue to next page (y/n): ";

    /**
     * Show view
     * @param users take the users list
     * @param page take the page number
     */
    public void showView(List<User> users, int page) {
        System.out.println();
        System.out.println(String.format(PAGE_NAME, page));

        for (User user : users) {
            System.out.println(user.getName());
        }

        System.out.println(String.format(PAGE_NAME, page));
    }

    /**
     * Asking for a more records
     * @return boolean result
     */
    public boolean showMore() {
        return KeyboardUtil.continueShowing(CONTINUE_MESSAGE);
    }

}
