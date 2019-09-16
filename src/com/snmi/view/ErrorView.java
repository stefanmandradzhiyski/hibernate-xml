package com.snmi.view;

/**
 * Error view
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class ErrorView {

    /**
     * Constants
     */
    private static final String PAGE_NAME = "---ERROR VIEW---";

    /**
     * Show view
     * @param message take the view message
     */
    public void showView(String message) {
        System.out.println();
        System.out.println(PAGE_NAME);
        System.out.println(message);
        System.out.println(PAGE_NAME);
        System.out.println();
    }

}
