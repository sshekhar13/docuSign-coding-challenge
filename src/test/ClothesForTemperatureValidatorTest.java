package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import model.Actions;
import model.Person;
import model.Temperature;

import org.junit.Before;
import org.junit.Test;

import validators.ClothesForTemperatureValidator;
import validators.impl.ClothesForTemperatureValidatorImpl;
import factory.Validation;

public class ClothesForTemperatureValidatorTest {

    private ClothesForTemperatureValidator<Person> validator;
    private List<Actions> actions = new ArrayList<Actions>();

    @Mock
    private Validation<Person> allValidators;

    @Before
    public void setup() {
        validator = new ClothesForTemperatureValidatorImpl();
        actions.add(Actions.TAKE_OFF_PAJAMAS);
        actions.add(Actions.PUT_ON_PANTS);
        actions.add(Actions.PUT_ON_SHIRT);
        actions.add(Actions.PUT_ON_HEAD_WEAR);
        actions.add(Actions.PUT_ON_FOOTWEAR);
        actions.add(Actions.LEAVE_HOUSE);
    }

    @Test
    public void hasValidClothesForWeatherTest() {
        Person person = new Person(Temperature.HOT, actions);
        person.setValidator(allValidators);
        boolean validClothes = validator.validClothesForWeather(person);
        assertTrue(validClothes);
    }
    
    @Test
    public void hasSocksInHotWeatherTest() {
        actions.removeAll(actions);
        actions.add(Actions.TAKE_OFF_PAJAMAS);
        actions.add(Actions.PUT_ON_PANTS);
        actions.add(Actions.PUT_ON_SHIRT);
        actions.add(Actions.PUT_ON_HEAD_WEAR);
        actions.add(Actions.PUT_ON_SOCKS);
        actions.add(Actions.LEAVE_HOUSE);
        Person person = new Person(Temperature.HOT, actions);
        person.setValidator(allValidators);
        boolean validClothes = validator.validClothesForWeather(person);
        assertFalse(validClothes);
    }
    
    @Test
    public void hasJacketInHotWeatherTest() {
        actions.removeAll(actions);
        actions.add(Actions.TAKE_OFF_PAJAMAS);
        actions.add(Actions.PUT_ON_PANTS);
        actions.add(Actions.PUT_ON_SHIRT);
        actions.add(Actions.PUT_ON_JACKET);
        actions.add(Actions.PUT_ON_HEAD_WEAR);
        actions.add(Actions.LEAVE_HOUSE);
        Person person = new Person(Temperature.HOT, actions);
        person.setValidator(allValidators);
        boolean validClothes = validator.validClothesForWeather(person);
        assertFalse(validClothes);
    }

}
