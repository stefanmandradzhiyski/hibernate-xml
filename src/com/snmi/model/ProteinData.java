package com.snmi.model;

/**
 * Protein data entity which hold full information about the user's protein data information
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class ProteinData {

    /**
     * Variables
     */
    private int id;
    private int total;
    private int goal;
    //Taking a specific user to create an one to one relationship
    private User user;

    /**
     * Getters and setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
