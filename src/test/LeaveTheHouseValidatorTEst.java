package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Actions;
import model.Person;
import model.Temperature;

import org.junit.Before;
import org.junit.Test;

import validators.LeaveTheHouseValidator;
import validators.impl.LeaveTheHouseValidatorImpl;
import factory.Validation;

public class LeaveTheHouseValidatorTEst {

    private LeaveTheHouseValidator<Person> validator;
    private List<Actions> actions = new ArrayList<Actions>();

    @Mock
    private Validation<Person> allValidators;

    @Before
    public void setup() {
        validator = new LeaveTheHouseValidatorImpl();
        actions.add(Actions.TAKE_OFF_PAJAMAS);
        actions.add(Actions.PUT_ON_PANTS);
        actions.add(Actions.PUT_ON_SHIRT);
        actions.add(Actions.PUT_ON_HEAD_WEAR);
        actions.add(Actions.PUT_ON_FOOTWEAR);
        actions.add(Actions.LEAVE_HOUSE);
    }

    @Test
    public void canILeaveTheHouseTrueTest() {
        Person person = new Person(Temperature.HOT, actions);
        person.setValidator(allValidators);
        boolean leave = validator.canILeaveTheHouse(person);
        assertTrue(leave);
    }
    
    @Test
    public void canILeaveTheHouseFalseTest1() {
        actions.add(Actions.PUT_ON_JACKET);
        Person person = new Person(Temperature.HOT, actions);
        person.setValidator(allValidators);
        boolean leave = validator.canILeaveTheHouse(person);
        assertFalse(leave);
    }
    
    @Test
    public void canILeaveTheHouseFalseTest2() {
        actions.remove(actions.size()-1);
        Person person = new Person(Temperature.HOT, actions);
        person.setValidator(allValidators);
        boolean leave = validator.canILeaveTheHouse(person);
        assertFalse(leave);
    }
    
    

}
