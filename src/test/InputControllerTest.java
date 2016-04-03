package test;

import static org.junit.Assert.*;

import java.util.List;

import model.Person;

import org.junit.Before;
import org.junit.Test;

import validators.ActionOrdersValidator;
import validators.BasicValidator;
import validators.ClothesForTemperatureValidator;
import validators.DuplicateItemsValidator;
import validators.LeaveTheHouseValidator;
import validators.PajamaValidator;
import controller.InputController;
import factory.Validation;

public class InputControllerTest {

    private InputController controller;
    @Mock
    private Validation<Person> allValidators;

    @Before
    public void setup() {
      controller = new InputController();
    }
    
    @Test
    public void createValidationRulesTest(){
        List<BasicValidator<Person>> rules = controller.createValidationRules();
        assertTrue(rules.get(0) instanceof PajamaValidator);
        assertTrue(rules.get(1) instanceof ActionOrdersValidator);
        assertTrue(rules.get(2) instanceof ClothesForTemperatureValidator);
        assertTrue(rules.get(3) instanceof DuplicateItemsValidator);
        assertTrue(rules.get(4) instanceof LeaveTheHouseValidator);
    }
    
    @Test
    public void checkValidInputTest(){
        assertTrue(controller.isValidInput("HOT 8,6,4,2,1,7"));
    }
    
    @Test
    public void checkInvalidInputBlankTest(){
        assertFalse(controller.isValidInput(""));
    }
    
    @Test
    public void checkInvalidNullInputTest(){
        assertFalse(controller.isValidInput(null));
    }
    
    @Test
    public void parsePositive1Test(){
        String ret = controller.parseAndReturnOutput("HOT 8,6,4,2,1,7");
        assertEquals("Removing PJs, shorts, t-shirt, sun visor, sandals, leaving house" , ret);
    }
    
    @Test
    public void parsePositive2Test(){
        String ret = controller.parseAndReturnOutput("HOT 8");
        assertEquals("Removing PJs, fail" , ret);
    }
    
    @Test
    public void parseNegativeTest(){
        String ret = controller.parseAndReturnOutput("HOT ");
        assertEquals("Please Enter valid request. Ex: HOT 8,6,4,2,1,7" , ret);
    }
    
    @Test
    public void parseNegative2Test(){
        String ret = controller.parseAndReturnOutput("HOT ,,,,,,");
        assertEquals("Please Enter valid request. Ex: HOT 8,6,4,2,1,7" , ret);
    }
    
    @Test
    public void parseNegative3Test(){
        String ret = controller.parseAndReturnOutput("sdsdsd 8,6,4,2,1,7");
        assertEquals("Please Enter valid request. Ex: HOT 8,6,4,2,1,7" , ret);
    }
    
    
    
}
