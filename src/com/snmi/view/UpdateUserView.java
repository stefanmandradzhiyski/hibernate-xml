package com.snmi.view;

import com.snmi.enums.UpdateTypes;
import com.snmi.utils.KeyboardUtil;

/**
 * Update view
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class UpdateUserView {

    /**
     * Constants
     */
    private static final String PAGE_NAME = "---UPDATE VIEW---";
    private static final String CHOOSE_UPDATE_TYPE_MESSAGE = "Choose which user property you want to update (name/goal/total): ";
    private static final String ID_MESSAGE = "Input User's ID which you want to update: ";
    private static final String ID_MESSAGE_ERROR = "Invalid ID!";
    private static final String NAME_MESSAGE = "Type new user's name: ";
    private static final String PROTEIN_MESSAGE = "Input new user's %s: ";
    private static final String PROTEIN_MESSAGE_ERROR = "Invalid protein number!";

    /**
     * Get the update type from view
     * @return the update type
     */
    public UpdateTypes chooseUpdateType() {
        System.out.println();
        System.out.println(PAGE_NAME);

        return KeyboardUtil.chooseUpdateType(CHOOSE_UPDATE_TYPE_MESSAGE);
    }

    /**
     * Get the user id from view
     * @return the id
     */
    public int getUserId() {
        return KeyboardUtil.getNumber(ID_MESSAGE, ID_MESSAGE_ERROR);
    }

    /**
     * Get the user name from view
     * @return the name
     */
    public String getUserNameView() {
        return KeyboardUtil.getName(NAME_MESSAGE);
    }

    /**
     * Get the user protein number from view
     * @param updateTypes take the update type
     * @return protein number
     */
    public int getUserProteinView(UpdateTypes updateTypes) {
        return KeyboardUtil.getNumber(String.format(PROTEIN_MESSAGE, updateTypes.toString()), PROTEIN_MESSAGE_ERROR);
    }
}
