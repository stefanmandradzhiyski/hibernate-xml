package com.snmi.view;

/**
 * Complete view
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class CompleteView {

    /**
     * Constants
     */
    private static final String PAGE_NAME = "---SUCCESSFUL VIEW---";

    /**
     * Show view
     * @param message take the view message
     */
    public void showView(String message) {
        System.out.println();
        System.out.println(PAGE_NAME);
        System.out.println(message);
        System.out.println(PAGE_NAME);
    }

}
