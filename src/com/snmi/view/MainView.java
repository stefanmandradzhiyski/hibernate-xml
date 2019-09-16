package com.snmi.view;

import com.snmi.enums.Actions;
import com.snmi.utils.KeyboardUtil;

/**
 * Main view (Entry view)
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class MainView {

    /**
     * Constants
     */
    private static final String PAGE_NAME = "---MAIN VIEW---";

    /**
     * Show view and take the program action
     * @param question take the view question
     * @return the chosen action
     */
    public Actions showView(String question) {
        System.out.println();
        System.out.println(PAGE_NAME);
        System.out.print(question);
        return KeyboardUtil.getAction();
    }

}
