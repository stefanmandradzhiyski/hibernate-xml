package com.snmi.utils;

/**
 * Validator util which is using to validate the user input
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class ValidatorUtil {

    /**
     * Constants
     */
    private static final String NAME = "name";
    private static final String GOAL = "goal";
    private static final String TOTAL = "total";

    /**
     * Private constructor (No instnace needed)
     */
    private ValidatorUtil() {}

    /**
     * Check if the name is valid
     * @param name take the name
     * @return validated name
     */
    public static boolean isNameValid(String name) {
        return name != null && name.length() >= 3 && name.length() <= 20 && name.matches("[a-zA-Z ]+");
    }

    /**
     * Check if the protein number is valid
     * @param number take the protein number
     * @return validated protein number
     */
    public static boolean isProteinValid(int number) {
        return number > 0 && number <= 3000;
    }

    /**
     * Check if the alert message is valid
     * @param alert take the alert message
     * @return validated alert message
     */
    public static boolean isAlertValid(String alert) {
        return alert != null && alert.length() > 0 && alert.length() <= 200;
    }

    /**
     * Check if the updated type is valid
     * @param type take the update type
     * @return validated update type
     */
    public static boolean isValidUpdateType(String type) {
        return !NAME.equals(type) && !GOAL.equals(type) && !TOTAL.equals(type);
    }

}
