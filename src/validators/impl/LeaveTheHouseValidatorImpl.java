package validators.impl;

import java.util.List;

import model.Actions;
import model.Person;
import model.Temperature;
import validators.BasicValidator;
import validators.LeaveTheHouseValidator;

public class LeaveTheHouseValidatorImpl implements
        LeaveTheHouseValidator<Person>, BasicValidator<Person> {

    @Override
    public boolean validate(Person person) {
        return canILeaveTheHouse(person);
    }

    @Override
    public int indexInvalidItem(Person person) {
        if (!validate(person)) {
            List<Actions> actions = person.getActions();

            if (actions.size() > 0 && actions.contains(Actions.LEAVE_HOUSE)
                    && actions.get(actions.size() - 1) != Actions.LEAVE_HOUSE)
                return actions.indexOf(Actions.LEAVE_HOUSE);

            if (actions.contains(Actions.LEAVE_HOUSE)
                    && !isClothingOrderCorrect(person))
                return actions.indexOf(Actions.LEAVE_HOUSE);

        }

        return person.getActions().size();
    }

    @Override
    public boolean canILeaveTheHouse(Person person) {
        List<Actions> actions = person.getActions();
        if (!isLeaveHouseLastAction(actions) && isClothingOrderCorrect(person)) {
            return true;
        }

        return false;
    }

    private boolean isLeaveHouseLastAction(List<Actions> actions) {
        if (actions.size() > 0 && actions.contains(Actions.LEAVE_HOUSE)
                && actions.get(actions.size() - 1) != Actions.LEAVE_HOUSE)
            return true;
        return false;
    }

    private boolean isClothingOrderCorrect(Person person) {
        if (person.getTemp() == Temperature.COLD) {
            if (person.getActions().size() != 8)
                return false;
        } else {
            if (person.getActions().size() != 6)
                return false;
        }
        return true;
    }

}