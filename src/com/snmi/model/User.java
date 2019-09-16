package com.snmi.model;

import java.util.*;

/**
 * User entity which hold and combine all entities
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class User {

    /**
     * Variables
     */
    private int id;
    private String name;
    private ProteinData proteinData;
    //Many to many
    private Set<GoalAlert> goalAlerts = new HashSet<>();
    //Mapping a list which is using to create a one to many relationship
    private List<UserHistory> history = new ArrayList<>();

    /**
     * Default constructor
     */
    public User() {
        //Making an one to one relationship
        setProteinData(new ProteinData());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProteinData getProteinData() {
        return proteinData;
    }

    /**
     * Setting a protein data user. Making an one to one relationship
     * @param proteinData take the protein data entity
     */
    public void setProteinData(ProteinData proteinData) {
        this.proteinData = proteinData;
        proteinData.setUser(this);
    }

    public List<UserHistory> getHistory() {
        return history;
    }

    public void setHistory(List<UserHistory> history) {
        this.history = history;
    }

    public Set<GoalAlert> getGoalAlerts() {
        return goalAlerts;
    }

    public void setGoalAlerts(Set<GoalAlert> goalAlerts) {
        this.goalAlerts = goalAlerts;
    }

    /**
     * Set user to history item and add it to the list. Making an one to many relationship
     * @param userHistory take the user history entity
     */
    public void addHistory(UserHistory userHistory) {
        userHistory.setUser(this);
        history.add(userHistory);
    }

}
