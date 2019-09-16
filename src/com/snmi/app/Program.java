package com.snmi.app;

import com.snmi.controller.Dispatcher;
import com.snmi.view.MainView;

/**
 * Entry point of program
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class Program {

    /**
     * Constants
     */
    private static final String START_VIEW_MESSAGE = "What do you want to do? (C/RALL/RBYID/RBYNAME/PR/U/D/Q): ";

    public static void main(String[] args) {

        MainView view = new MainView();
        Dispatcher controller = new Dispatcher(view);
        controller.showView(START_VIEW_MESSAGE);

    }

}
