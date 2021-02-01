package customfilter;

@FunctionalInterface
public interface Check<T> {
    public boolean test(T t);
}