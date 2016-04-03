package validators;

/**
 * This interface provides the methods to check for validation rules related to
 * the fact that the first action to be taken should be to "Remove PJs".
 * 
 * @author Shashank Shekhar
 *
 * @param <T> The model for this interface (Person)
 */
public interface PajamaValidator<T> {
    /**
     * This methods checks if the first action command(8) is to remove the pajamas or not
     * @param model The model
     * @return true, if 8 is the first command, false otherwise
     */
    boolean arePajamasOff(T model);
}
