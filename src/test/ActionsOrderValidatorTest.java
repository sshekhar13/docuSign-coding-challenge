package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Actions;
import model.Person;
import model.Temperature;

import org.junit.Before;
import org.junit.Test;

import validators.ActionOrdersValidator;
import validators.ClothesForTemperatureValidator;
import validators.impl.ActionOrdersValidatorImpl;
import validators.impl.ClothesForTemperatureValidatorImpl;
import factory.Validation;

public class ActionsOrderValidatorTest {

    private ActionOrdersValidator<Person> validator;
    private List<Actions> actions = new ArrayList<Actions>();

    @Mock
    private Validation<Person> allValidators;

    @Before
    public void setup() {
        validator = new ActionOrdersValidatorImpl();
        actions.add(Actions.TAKE_OFF_PAJAMAS);
        actions.add(Actions.PUT_ON_PANTS);
        actions.add(Actions.PUT_ON_SHIRT);
        actions.add(Actions.PUT_ON_HEAD_WEAR);
        actions.add(Actions.PUT_ON_FOOTWEAR);
        actions.add(Actions.LEAVE_HOUSE);
    }
    
    @Test
    public void actionsInCorrectOrder() {
        Person person = new Person(Temperature.HOT, actions);
        person.setValidator(allValidators);
        boolean order = validator.areActionsInTheCorrectOrder(person);
        assertTrue(order);
    }
    
    @Test
    public void socksAfterShoes() {
        actions.removeAll(actions);
        actions.add(Actions.TAKE_OFF_PAJAMAS);
        actions.add(Actions.PUT_ON_PANTS);
        actions.add(Actions.PUT_ON_SHIRT);
        actions.add(Actions.PUT_ON_FOOTWEAR);
        actions.add(Actions.PUT_ON_SOCKS);
        actions.add(Actions.LEAVE_HOUSE);
        Person person = new Person(Temperature.HOT, actions);
        person.setValidator(allValidators);
        boolean order = validator.areActionsInTheCorrectOrder(person);
        assertFalse(order);
    }
    
    @Test
    public void pantsAfterShoes() {
        actions.removeAll(actions);
        actions.add(Actions.PUT_ON_FOOTWEAR);
        actions.add(Actions.PUT_ON_PANTS);
        actions.add(Actions.TAKE_OFF_PAJAMAS);
        actions.add(Actions.PUT_ON_SHIRT);
        actions.add(Actions.PUT_ON_SOCKS);
        actions.add(Actions.LEAVE_HOUSE);
        Person person = new Person(Temperature.HOT, actions);
        person.setValidator(allValidators);
        boolean order = validator.areActionsInTheCorrectOrder(person);
        assertFalse(order);
    }
    
    @Test
    public void shirtAfterHeadwear() {
        actions.removeAll(actions);
        actions.add(Actions.TAKE_OFF_PAJAMAS);
        actions.add(Actions.PUT_ON_PANTS);
        actions.add(Actions.PUT_ON_HEAD_WEAR);
        actions.add(Actions.PUT_ON_SHIRT);
        actions.add(Actions.PUT_ON_SOCKS);
        actions.add(Actions.PUT_ON_FOOTWEAR);
        actions.add(Actions.LEAVE_HOUSE);
        Person person = new Person(Temperature.HOT, actions);
        person.setValidator(allValidators);
        boolean order = validator.areActionsInTheCorrectOrder(person);
        assertFalse(order);
    }
    
    @Test
    public void shirtAfterJacket() {
        actions.removeAll(actions);
        actions.add(Actions.TAKE_OFF_PAJAMAS);
        actions.add(Actions.PUT_ON_PANTS);
        actions.add(Actions.PUT_ON_JACKET);
        actions.add(Actions.PUT_ON_SHIRT);
        actions.add(Actions.PUT_ON_FOOTWEAR);
        actions.add(Actions.PUT_ON_SOCKS);
        actions.add(Actions.LEAVE_HOUSE);
        Person person = new Person(Temperature.HOT, actions);
        person.setValidator(allValidators);
        boolean order = validator.areActionsInTheCorrectOrder(person);
        assertFalse(order);
    }
}
