package com.snmi.utils;

import com.snmi.enums.Actions;
import com.snmi.enums.UpdateTypes;
import java.util.Scanner;

/**
 * Keyboard util which is used for all user inputs
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class KeyboardUtil {

    /**
     * Constants
     */
    private static Scanner scanner = new Scanner(System.in);
    private static final String CREATE = "c";
    private static final String READ_ALL = "rall";
    private static final String READ_BY_ID = "rbyid";
    private static final String READ_BY_NAME = "rbyname";
    private static final String PAGE_READING = "pr";
    private static final String UPDATE = "u";
    private static final String DELETE = "d";
    private static final String QUIT = "q";
    private static final String NAME = "name";
    private static final String GOAL = "goal";
    private static final String TOTAL = "total";
    private static final String ILLEGAL_MESSAGE_ERROR = "This specific update type isn't implemented yet!";
    private static final String YES = "y";
    private static final String NO = "n";

    /**
     * Private constructor (No instance needed)
     */
    private KeyboardUtil() {}

    /**
     * Get the user action
     * @return the action
     */
    public static Actions getAction() {
        String action = scanner.nextLine().toLowerCase().trim();
        switch (action) {
            case CREATE: return Actions.CREATE;
            case READ_ALL: return Actions.READ_ALL;
            case READ_BY_ID: return Actions.READ_BY_ID;
            case READ_BY_NAME: return Actions.READ_BY_NAME;
            case PAGE_READING: return Actions.PAGE_READING;
            case UPDATE: return Actions.UPDATE;
            case DELETE: return Actions.DELETE;
            case QUIT: return Actions.QUIT;
            default: return Actions.INVALID;
        }
    }

    /**
     * Get the user name
     * @param message take the view message
     * @return the name
     */
    public static String getName(String message) {
        String name;
        do {
            System.out.print(message);
            name = scanner.nextLine();
        } while (!ValidatorUtil.isNameValid(name));

        return name;
    }

    /**
     * Get the protein number
     * @param message take the view message
     * @param invalidMessage take the view error message
     * @return protein number
     */
    public static int getProteinNumber(String message, String invalidMessage) {
        int number = 0;
        do {
            System.out.print(message);
            try {
                number = Integer.parseInt(scanner.nextLine().trim());
            } catch (IllegalArgumentException e) {
                System.out.println(invalidMessage);
            }
        } while (!ValidatorUtil.isProteinValid(number));

        return number;
    }

    /**
     * Take how many alerts message the user will have
     * @param message take the view message
     * @param invalidMessage take the view error message
     * @return alerts number
     */
    public static int getAlertNumber(String message, String invalidMessage) {
        boolean validNumber = true;
        int number = 0;
        do {
            System.out.print(message);
            try {
                number = Integer.parseInt(scanner.nextLine().trim());
                if (number > 0 && number <= 5) {
                    validNumber = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(invalidMessage);
            }
        } while (validNumber);

        return number;
    }

    /**
     * Get an alert message
     * @param message take the view message
     * @return alert message
     */
    public static String getAlert(String message) {
        String alert;
        do {
            System.out.print(message);
            alert = scanner.nextLine();
        } while (!ValidatorUtil.isAlertValid(alert));

        return alert;
    }

    /**
     * Get a number
     * @param message take the view message
     * @param invalidMessage take the view error message
     * @return number
     */
    public static int getNumber(String message, String invalidMessage) {
        boolean validNumber = true;
        int number = 0;
        do {
            System.out.print(message);
            try {
                number = Integer.parseInt(scanner.nextLine().trim());
                validNumber = false;
            } catch (IllegalArgumentException e) {
                System.out.println(invalidMessage);
            }
        } while (validNumber);

        return number;
    }

    /**
     * Choosing the update type
     * @param message take the view message
     * @return update type
     */
    public static UpdateTypes chooseUpdateType(String message) {
        Scanner scanner = new Scanner(System.in);
        String type;
        do {
            System.out.print(message);
            type = scanner.nextLine().trim().toLowerCase();
        } while(ValidatorUtil.isValidUpdateType(type));

        switch (type) {
            case NAME: return UpdateTypes.NAME;
            case GOAL: return UpdateTypes.GOAL;
            case TOTAL: return UpdateTypes.TOTAL;
            default: throw new IllegalArgumentException(ILLEGAL_MESSAGE_ERROR);
        }

    }

    /**
     * Do you want to see a next page
     * @param message take the view message
     * @return boolean result
     */
    public static boolean continueShowing(String message) {
        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            System.out.print(message);
            answer = scanner.nextLine().toLowerCase().trim();
        } while (!answer.equals(YES) && !answer.equals(NO));

        return answer.equals(YES);

    }

}
