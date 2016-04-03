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

import validators.PajamaValidator;
import validators.impl.PajamaValidatorImpl;
import factory.Validation;

public class PajamaValidatorTest {

    private PajamaValidator<Person> pajamaValidator;
    private List<Actions> actions = new ArrayList<Actions>();

    @Mock
    private Validation<Person> personValidation;

    @Before
    public void setup() {
        pajamaValidator = new PajamaValidatorImpl();
        
    }

    @Test
    public void arePajamasOffTestFalse() {
        actions.add(Actions.PUT_ON_SHIRT);
        Person person = new Person(Temperature.COLD, actions);
        person.setValidator(personValidation);
        boolean doIlookFine = pajamaValidator.arePajamasOff(person);
        assertFalse(doIlookFine);
    }
    
    @Test
    public void arePajamasOffTestTrue() {
        actions.add(Actions.TAKE_OFF_PAJAMAS);
        Person person = new Person(Temperature.COLD, actions);
        person.setValidator(personValidation);
        boolean doIlookFine = pajamaValidator.arePajamasOff(person);
        assertTrue(doIlookFine);
    }


    @Test
    public void pajamas_Are_On_And_I_Do_Nothing_Else_Is_Valid() {
        actions.add(Actions.TAKE_OFF_PAJAMAS);
        Person person = new Person(Temperature.COLD, actions);
        person.setValidator(personValidation);
        boolean doIlookFine = pajamaValidator.arePajamasOff(person);
        assertTrue(doIlookFine);
    }

}
