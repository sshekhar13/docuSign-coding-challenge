package model;

/**
 * This is an Enum class which maintains the information about the temperature
 * whether it is HOT or COLD.
 * 
 * @author Shashank Shekhar
 *
 */
public enum Temperature {
    HOT("HOT"),
    COLD("COLD");

    private final String temperature;

    Temperature(String temperature) {
        this.temperature = temperature;
    }

    public static Temperature getTemperature(String temp){
        switch (temp) {
            case "HOT" : return Temperature.HOT;

            case "COLD" : return Temperature.COLD;

            default :
                throw new RuntimeException("passed in invalid value for Temperature enum");
        }
    }
}

