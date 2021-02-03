package org.example.customstreamapi.customfilter;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface ICustomFilter<T> {
    public List<T> filter(List<T> list,Predicate<? super T> predicate);
    public List<T> sort(List<T> list,Comparator<T> comparator);
    public List<T> paginate(List<T> list,int pageSize,int numberPage);
    public List<T> paginate(List<T> list,int pageSize,int numberFistPage,int numberLastPage);
}
