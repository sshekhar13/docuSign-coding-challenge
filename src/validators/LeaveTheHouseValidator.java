package validators;

/**
 * Interface that enforces the validation rule that - 
 * You cannot leave the house until all items of clothing are on (except socks and a jacket when it’s hot)
 * 
 * @author Shashank Shekhar
 *
 * @param <T> The model for the interface (Person)
 */
public interface LeaveTheHouseValidator<T> {
    /**
     * Method to check if all clothing items are on and last command is to leave the room
     * @param model The model for the interface (Person)
     * @return true if the above condition is met, false otherwise
     */
    boolean canILeaveTheHouse(T model);
}
