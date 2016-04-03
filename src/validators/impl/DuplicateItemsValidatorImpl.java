package validators.impl;

import java.util.List;

import model.Actions;
import model.Person;
import validators.BasicValidator;
import validators.DuplicateItemsValidator;

public class DuplicateItemsValidatorImpl implements DuplicateItemsValidator<Person>, BasicValidator<Person> {

    @Override
    public boolean validate(Person person) {
        if (hasDuplicateItems(person)){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int indexInvalidItem(Person person) {
        if (!validate(person)){
            List<Actions> actions = person.getActions();

            for (Actions clothes : actions) {
                int counter = 0;
                for (Actions clothesItem : actions) {
                    if (clothes == clothesItem)
                        counter++;
                }
                if (counter > 1) return actions.lastIndexOf(clothes);
            }
        }

        return person.getActions().size();
    }

    @Override
    public boolean hasDuplicateItems(Person person) {
        List<Actions> actions = person.getActions();
        for (Actions clothes : actions) {
            int counter = 0;
            for (Actions clothesItem : actions) {
                if (clothes == clothesItem)
                    counter++;
            }
            if (counter > 1) return true;
        }
        return false;
    }

}
