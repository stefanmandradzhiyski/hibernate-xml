package com.snmi.view;

import com.snmi.model.GoalAlert;
import com.snmi.model.UserHistory;
import com.snmi.model.User;
import com.snmi.utils.KeyboardUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Create view
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class CreateUserView {

    /**
     * Constants
     */
    private static final String PAGE_NAME = "---CREATE VIEW---";
    private static final String NAME_MESSAGE = "Input user name (3 to 20 symbols): ";
    private static final String PROTEIN_MESSAGE = "Input user protein %s (whole number from 1 to 3000): ";
    private static final String PROTEIN_MESSAGE_ERROR = "Invalid user protein %s. Please re-enter %s: ";
    private static final String ALERT_NUMBER_MESSAGE = "How many alert message do you want to create (1 to 5): ";
    private static final String ALERT_NUMBER_MESSAGE_ERROR = "Invalid number of alerts! Input new number.";
    private static final String ALERT_MESSAGE = "Input alert message (1 to 200 symbols): ";
    private static final String GOAL_HISTORY = "Set goal to %d";
    private static final String TOTAL_HISTORY = "Set total to %d";
    private static final String GOAL = "goal";
    private static final String TOTAL = "total";

    /**
     * Show view
     * @return the created user
     */
    public User showView() {
        System.out.println();
        System.out.println(PAGE_NAME);

        String name = KeyboardUtil.getName(NAME_MESSAGE);
        int goal = KeyboardUtil.getProteinNumber(String.format(PROTEIN_MESSAGE, GOAL), String.format(PROTEIN_MESSAGE_ERROR, GOAL, GOAL));
        int total = KeyboardUtil.getProteinNumber(String.format(PROTEIN_MESSAGE, TOTAL), String.format(PROTEIN_MESSAGE_ERROR, TOTAL, TOTAL));
        int alertNumber = KeyboardUtil.getAlertNumber(ALERT_NUMBER_MESSAGE, ALERT_NUMBER_MESSAGE_ERROR);
        List<String> alerts = new ArrayList<>();
        for (int i = 0; i < alertNumber; i++) {
            alerts.add(KeyboardUtil.getAlert(ALERT_MESSAGE));
        }

        return createUser(name, goal, total, alerts);
    }

    /**
     * Create user by user keyboard input
     * @param name take the name
     * @param goal take the goal
     * @param total take the total
     * @param alerts take alerts
     * @return created user
     */
    private User createUser(String name, int goal, int total, List<String> alerts) {
        User user = new User();
        user.setName(name);
        user.getProteinData().setGoal(goal);
        user.addHistory(new UserHistory(new Date(), String.format(GOAL_HISTORY, goal)));
        user.getProteinData().setTotal(total);
        user.addHistory(new UserHistory(new Date(), String.format(TOTAL_HISTORY, total)));
        for (String alert : alerts) {
            user.getGoalAlerts().add(new GoalAlert(alert));
        }

        return user;
    }

}
