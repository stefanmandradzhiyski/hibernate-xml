package com.snmi.model;

import java.util.Date;

/**
 * User history entity which hold the user actions information
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class UserHistory {

    /**
     * Variables
     */
    private int id;
    private Date entryTime;
    private String entry;
    //Taking an user entity
    private User user;

    /**
     * Default constructor
     */
    public UserHistory() {}

    /**
     * Custom constructor
     * @param entryTime take the time when the history have been created
     * @param entry take the history's message
     */
    public UserHistory(Date entryTime, String entry) {
        super();
        this.entryTime = entryTime;
        this.entry = entry;
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

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
