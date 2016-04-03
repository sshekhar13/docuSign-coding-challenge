package controller;

import java.util.ArrayList;
import java.util.List;

import model.Actions;
import model.Person;
import model.Temperature;
import validators.BasicValidator;
import validators.impl.ActionOrdersValidatorImpl;
import validators.impl.ClothesForTemperatureValidatorImpl;
import validators.impl.DuplicateItemsValidatorImpl;
import validators.impl.LeaveTheHouseValidatorImpl;
import validators.impl.PajamaValidatorImpl;
import factory.Validation;
import factory.impl.ValidationImpl;

/**
 * This is a controller class that handles all the input from the user
 * and displays the results accordingly. This class is responsible for 
 * making sure that all the validation rules are taken care of as well.
 * 
 * @author Shashank Shekhar
 *
 */
public class InputController {
    private static final String FAIL = "fail";

    public String parseAndReturnOutput(String input) {
        String[] inputLine = null;
        if (isValidInput(input)) {
            inputLine = input.split(" "); // Separate HOT|COLD from the input commands
            String temp = inputLine[0];
            String[] actions = inputLine[1].split(","); // Split the commands and store it in an array
            /**
             * Create a List of Actions depending on their command code.
             */
            List<Actions> actionsList = new ArrayList<Actions>();
            for (int i = 0; i < actions.length; i++) {
                int action = Integer.parseInt(actions[i]);
                actionsList.add(Actions.getAction(action));
            }
            
            // Fetch the Temperature type: HOT or COLD
            Temperature temperature = Temperature.getTemperature(temp);
            Person person = new Person(temperature, actionsList);
            // Create all the validation rules and attach it to Person
            List<BasicValidator<Person>> validations = createValidationRules();
            Validation<Person> validator = new ValidationImpl(validations);
            person.setValidator(validator);
            
            // Get the result of the input
            String result = createResultFromActions(person);
            return result;
        }
        return "Please Enter valid request. Ex: HOT 8,6,4,2,1,7";
    }
    
    /**
     * This function takes a Person input and returns the appropriate output
     * @param person The Object that contains all data about the temperature, rules and list of action/commands
     * @return The desired output
     */
    public String createResultFromActions(Person person) {
        int endIndex = person.getValidator().indexInvalidItem(person);
        return processResults(person, endIndex);
    }

    public String processResults(Person person, int endIndex) {
        if (endIndex < 0)
            return FAIL;

        List<Actions> actions = person.getActions();
        List<Actions> values = actions.subList(0, endIndex);
        StringBuilder results = new StringBuilder();
        Temperature temp = person.getTemp();

        for (Actions morningActions : values) {
            results.append(morningActions.getDescription(temp));
            results.append(", ");
        }

        if (temp == Temperature.COLD) {
            if (values.size() < 8) {
                results.append(FAIL);
                results.append(", ");
            }
        } else if (temp == Temperature.HOT) {
            if (values.size() < 6) {
                results.append(FAIL);
                results.append(", ");
            }
        }
        
        String output = results.toString().trim();
        return output.substring(0, output.length() - 1);
    }
    /**
     * Creates all the validation rules for actions.
     * @return A list of all the validations
     */
    public List<BasicValidator<Person>> createValidationRules() {
        List<BasicValidator<Person>> validationElements = new ArrayList<>();
        validationElements.add(new PajamaValidatorImpl());
        validationElements.add(new ActionOrdersValidatorImpl());
        validationElements.add(new ClothesForTemperatureValidatorImpl());
        validationElements.add(new DuplicateItemsValidatorImpl());
        validationElements.add(new LeaveTheHouseValidatorImpl());
        return validationElements;
    }
    /**
     * Takes an input string and validates if the input is in the correct format
     * @param input The input string
     * @return true if the string is in desired format, false otherwise
     */
    public boolean isValidInput(String input) {
        if (input == null)
            return false;
        String pattern = "^(HOT|COLD)\\s[1-8](,[1-8])*$";
        boolean match = input.matches(pattern);
        return match;
    }
}
