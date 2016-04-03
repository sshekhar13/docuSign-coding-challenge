package validators.impl;

import java.util.List;

import model.Actions;
import model.Person;
import validators.ActionOrdersValidator;
import validators.BasicValidator;

public class ActionOrdersValidatorImpl implements
        ActionOrdersValidator<Person>, BasicValidator<Person> {

    @Override
    public boolean validate(Person person) {
        return areActionsInTheCorrectOrder(person);
    }

    @Override
    public int indexInvalidItem(Person person) {
        if (!validate(person)) {
            List<Actions> actions = person.getActions();
            if (isSocksAfterShoes(actions))
                return actions.indexOf(Actions.PUT_ON_FOOTWEAR);
            if (isPantsAfterShoes(actions))
                return actions.indexOf(Actions.PUT_ON_FOOTWEAR);
            if (isShirtAfterHeadwear(actions))
                return actions.indexOf(Actions.PUT_ON_HEAD_WEAR);
            if (isShirtAfterJacket(actions))
                return actions.indexOf(Actions.PUT_ON_JACKET);
        }
        return person.getActions().size();
    }

    @Override
    public boolean areActionsInTheCorrectOrder(Person person) {
        List<Actions> actions = person.getActions();
        if (isSocksAfterShoes(actions))
            return false;
        if (isPantsAfterShoes(actions))
            return false;
        if (isShirtAfterHeadwear(actions))
            return false;
        if (isShirtAfterJacket(actions))
            return false;
        return true;
    }
    /**
     * Checks if the command to wear a shirt comes after the command to wear a jacket
     * @param actions List of actions
     * @return true if the command to wear a shirt comes after the command to wear a jacket, false otherwise
     */
    private boolean isShirtAfterJacket(List<Actions> actions) {
        if (actions.contains(Actions.PUT_ON_SHIRT)
                && actions.contains(Actions.PUT_ON_JACKET)) {
            if (actions.indexOf(Actions.PUT_ON_SHIRT) > actions
                    .indexOf(Actions.PUT_ON_JACKET))
                return true;
        }
        return false;
    }
    
    /**
     * Checks if the command to wear a shirt comes after the command to wear a head-wear
     * @param actions List of actions
     * @return true if the command to wear a shirt comes after the command to wear a head-wear, false otherwise
     */
    private boolean isShirtAfterHeadwear(List<Actions> actions) {
        if (actions.contains(Actions.PUT_ON_SHIRT)
                && actions.contains(Actions.PUT_ON_HEAD_WEAR)) {
            if (actions.indexOf(Actions.PUT_ON_SHIRT) > actions
                    .indexOf(Actions.PUT_ON_HEAD_WEAR))
                return true;
        }
        return false;
    }
    
    /**
     * Checks if the command to wear pants comes after the command to wear shoes
     * @param actions List of actions
     * @return true if the command to wear pants comes after the command to wear shoes, false otherwise
     */
    private boolean isPantsAfterShoes(List<Actions> actions) {
        if (actions.contains(Actions.PUT_ON_PANTS)
                && actions.contains(Actions.PUT_ON_FOOTWEAR)) {
            if (actions.indexOf(Actions.PUT_ON_PANTS) > actions
                    .indexOf(Actions.PUT_ON_FOOTWEAR))
                return true;
        }
        return false;
    }
    
    /**
     * Checks if the command to wear socks comes after the command to wear shoes
     * @param actions List of actions
     * @return true if the command to wear socks comes after the command to wear shoes, false otherwise
     */
    private boolean isSocksAfterShoes(List<Actions> actions) {
        if (actions.contains(Actions.PUT_ON_SOCKS)
                && actions.contains(Actions.PUT_ON_FOOTWEAR)) {
            if (actions.indexOf(Actions.PUT_ON_SOCKS) > actions
                    .indexOf(Actions.PUT_ON_FOOTWEAR))
                return true;
        }
        return false;
    }

}
