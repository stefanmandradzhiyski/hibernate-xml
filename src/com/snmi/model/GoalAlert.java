package com.snmi.model;

/**
 * Goal alert entity which hold the goal alert messages
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class GoalAlert {

    /**
     * Variables
     */
    private int id;
    private String message;

    /**
     * Default constructor
     */
    public GoalAlert() {}

    /**
     * Custom constructor
     * @param message take the message of goal alert
     */
    public GoalAlert(String message) {
        this.message = message;
    }

    /**
     * Getters and setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
