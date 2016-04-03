package validators.impl;


import java.util.List;

import model.Actions;
import model.Person;
import validators.BasicValidator;
import validators.PajamaValidator;

public class PajamaValidatorImpl implements PajamaValidator<Person>,
        BasicValidator<Person> {

    @Override
    public boolean validate(Person person) {
        return arePajamasOff(person);
    }

    @Override
    public boolean arePajamasOff(Person person) {
        List<Actions> actions = person.getActions();
        Actions firstAction = actions.get(0);
        if (firstAction != Actions.TAKE_OFF_PAJAMAS)
            return false;
        return true;
    }

    @Override
    public int indexInvalidItem(Person person) {
        if (!validate(person)) {
            List<Actions> morningActions = person.getActions();
            if (morningActions.get(0) != Actions.TAKE_OFF_PAJAMAS)
                return morningActions.indexOf(Actions.TAKE_OFF_PAJAMAS);
        }
        return person.getActions().size();
    }

}
