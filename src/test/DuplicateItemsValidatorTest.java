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

import validators.DuplicateItemsValidator;
import validators.impl.DuplicateItemsValidatorImpl;
import factory.Validation;

public class DuplicateItemsValidatorTest {

    private DuplicateItemsValidator<Person> validator;
    private List<Actions> actions = new ArrayList<Actions>();

    @Mock
    private Validation<Person> allValidators;

    @Before
    public void setup() {
        validator = new DuplicateItemsValidatorImpl();
        actions.add(Actions.TAKE_OFF_PAJAMAS);
        actions.add(Actions.PUT_ON_PANTS);
        actions.add(Actions.PUT_ON_SHIRT);
        actions.add(Actions.PUT_ON_HEAD_WEAR);
        actions.add(Actions.PUT_ON_FOOTWEAR);
        actions.add(Actions.LEAVE_HOUSE);
    }

    @Test
    public void noDuplicateItemsTest() {
        Person person = new Person(Temperature.HOT, actions);
        person.setValidator(allValidators);
        boolean hasDupl = validator.hasDuplicateItems(person);
        assertFalse(hasDupl);
    }
    
    @Test
    public void duplicateItemsTest() {
        actions.add(Actions.PUT_ON_PANTS);
        Person person = new Person(Temperature.HOT, actions);
        person.setValidator(allValidators);
        boolean hasDupl = validator.hasDuplicateItems(person);
        assertTrue(hasDupl);
    }
    
    @Test
    public void onlyOneItemTest() {
        actions.removeAll(actions);
        actions.add(Actions.PUT_ON_HEAD_WEAR);
        Person person = new Person(Temperature.HOT, actions);
        person.setValidator(allValidators);
        boolean hasDupl = validator.hasDuplicateItems(person);
        assertFalse(hasDupl);
    }
    
    

}
