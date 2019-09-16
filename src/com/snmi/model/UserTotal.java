package com.snmi.model;

/**
 * User total entity which is using in dynamic instantiation by hibernate query
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class UserTotal {

    /**
     * Variables
     */
    private String name;
    private int total;

    /**
     * Custom constructor
     * @param name take the user's name from database
     * @param total take the user's total from database
     */
    public UserTotal(String name, int total) {
        this.name = name;
        this.total = total;
    }

    /**
     * Getters and setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
