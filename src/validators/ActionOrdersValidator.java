package validators;
/**
 * Interface that enforces the order validation rules  - 
 * 1. Socks must be put on before shoes 
 * 2. Pants must be put on before shoes
 * 3. The shirt must be put on before the head-wear or jacket
 * @author Shashank Shekhar
 *
 * @param <T> The model for the interface (Person)
 */
public interface ActionOrdersValidator<T> {
    /**
     * Checks if the actions are in the required order
     * @param model The model for the interface.
     * @return true if it is in order, false otherwise
     */
    boolean areActionsInTheCorrectOrder(T model);
}
