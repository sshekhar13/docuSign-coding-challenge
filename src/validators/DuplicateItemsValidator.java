package validators;

/**
 * Interface that enforces the rule that no item should be put on twice 
 * and all items should be put on at most once
 * 
 * @author Shashank Shekhar
 *
 * @param <T> The model for the interface (Person)
 */
public interface DuplicateItemsValidator<T> {
    /**
     * Method that enforces the rule of no duplicate items
     * @param model The model (Person)
     * @return true if there is a duplicate item being worn, false otherwise.
     */
    boolean hasDuplicateItems(T model);
}
