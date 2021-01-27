package CustomFilter;

@FunctionalInterface
public interface Check<T> {
    public boolean Test(T t);
}