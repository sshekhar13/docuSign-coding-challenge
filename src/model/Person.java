package model;

import java.util.List;

import factory.Validation;

/**
 * This is the model class that stores all the information about the event 
 * whether it is cold or hot, what are the action commands that need to be followed in order to
 * leave the house and the different validation rules that are in place.
 * 
 * @author Shashank Shekhar
 *
 */
public class Person {

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public void setActions(List<Actions> actions) {
        this.actions = actions;
    }

    private Temperature temp;
    private List<Actions> actions;
    private Validation<Person> validator;

    public Person(Temperature temp, List<Actions> actionsList) {
        this.temp = temp;
        this.actions = actionsList;
    }

    public Temperature getTemp() {
        return temp;
    }

    public Validation<Person> getValidator() {
        return validator;
    }

    public void setValidator(Validation<Person> validator) {
        this.validator = validator;
    }

    public List<Actions> getActions() {
        return actions;
    }

}
