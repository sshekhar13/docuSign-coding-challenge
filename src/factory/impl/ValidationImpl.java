package factory.impl;

import java.util.List;

import model.Person;
import validators.BasicValidator;
import factory.Validation;

public class ValidationImpl implements Validation<Person> {

    private List<BasicValidator<Person>> allValidations;

    public ValidationImpl(List<BasicValidator<Person>> allValidations) {
       this.allValidations = allValidations;
        
    }

    @Override
    public boolean validate(Person person) {
        for (BasicValidator<Person> validation : allValidations) {
            boolean valid = validation.validate(person);
            if (!valid){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int indexInvalidItem(Person person) {
        for (BasicValidator<Person> validation : allValidations) {
            boolean valid = validation.validate(person);
            if (!valid){
                return validation.indexInvalidItem(person);
            }
        }

        return person.getActions().size();
    }

}
