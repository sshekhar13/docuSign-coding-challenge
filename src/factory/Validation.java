package factory;

/**
 * Provides an Interface for all validation rules.
 * It has two methods validate and indexInvalidItem
 * 
 * @author Shashank Shekhar
 *
 * @param <T> It specifies the model to which these validation rules are associated, Ex - Person.
 */
public interface Validation<T> {
    /**
     * Validates specific rule of the validation class
     * @param model The model for which the validation needs to be done
     * @return true if valid, false otherwise
     */
    boolean validate(T model);
    
    /**
     * This function returns the index of the action command list which is not valid.
     * If all the actions are valid, it returns the length of the actions list.
     * @param model The model for which the validation needs to be done
     * @return The index of the invalid item in the actions list.
     */
    int indexInvalidItem(T model);
}
