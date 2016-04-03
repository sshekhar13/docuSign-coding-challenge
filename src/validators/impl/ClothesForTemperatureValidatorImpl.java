package validators.impl;

import java.util.List;

import model.Actions;
import model.Person;
import model.Temperature;
import validators.BasicValidator;
import validators.ClothesForTemperatureValidator;

public class ClothesForTemperatureValidatorImpl implements
        ClothesForTemperatureValidator<Person>, BasicValidator<Person> {

    @Override
    public boolean validate(Person person) {
        return validClothesForWeather(person);
    }

    @Override
    public int indexInvalidItem(Person person) {
        if (!validate(person)) {
            List<Actions> actions = person.getActions();
            int socksIndex = actions.contains(Actions.PUT_ON_SOCKS) ? actions
                    .indexOf(Actions.PUT_ON_SOCKS) : Integer.MAX_VALUE;
            int jacketIndex = actions.contains(Actions.PUT_ON_JACKET) ? actions
                    .indexOf(Actions.PUT_ON_JACKET) : Integer.MAX_VALUE;

            return socksIndex > jacketIndex ? jacketIndex : socksIndex;
        }

        return person.getActions().size();
    }

    @Override
    public boolean validClothesForWeather(Person person) {
        List<Actions> actions = person.getActions();
        if (person.getTemp() == Temperature.HOT) {
            if (actions.contains(Actions.PUT_ON_SOCKS)
                    || actions.contains(Actions.PUT_ON_JACKET))
                return false;
        }
        return true;
    }

}
