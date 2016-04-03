package validators;

public interface BasicValidator<T> {
    boolean validate(T domain);
    int indexInvalidItem(T model);
}
