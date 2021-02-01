package customfilter;

import java.util.Comparator;
import java.util.List;

public interface ICustomFilter<T> {
    public ICustomFilter<T> filter(Check<T> tCheck);
    public List<T> sort(Comparator<T> comparator);
    public List<T> paginate(int pageSize,int numberPage);
    public List<T> paginate(int pageSize,int numberFistPage,int numberLastPage);
    public List<T> getResult();
    public int count();

}