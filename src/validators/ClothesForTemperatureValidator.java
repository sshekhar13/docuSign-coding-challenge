package validators;

/**
 * Interface that enforces the rule one cannot put on shoes and socks 
 * when the temperature is HOT
 * 
 * @author Shashank Shekhar
 *
 * @param <T> The model for the interface (Person)
 */
public interface ClothesForTemperatureValidator<T> {
    /**
     * Method that returns true if the clothes that are being worn are appropriate 
     * for the weather(HOT or COLD)
     * @param model The model (Person)
     * @return true if it is appropriate, false otherwise.
     */
    boolean validClothesForWeather(T model);
}
