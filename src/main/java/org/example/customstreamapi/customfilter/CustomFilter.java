package org.example.customstreamapi.customfilter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomFilter<T> implements ICustomFilter<T>{
    @Override
    public List<T> filter(List<T> list, Predicate<? super T> predicate) {
       return list.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<T> sort(List<T> list, Comparator<T> comparator) {
        return list.stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public List<T> paginate(List<T> list, int pageSize, int numberPage) {
        int startPosition = pageSize * (numberPage-1);
        List<T> resultList = list.stream().skip(startPosition).limit(pageSize).collect(Collectors.toList());
        return resultList;
    }

    @Override
    public List<T> paginate(List<T> list, int pageSize, int numberFirstPage, int numberLastPage) {
        int startPosition = pageSize * (numberFirstPage-1);
        int endPosition = pageSize *(numberLastPage - numberFirstPage +1 );
        List<T> resultList = list.stream().skip(startPosition).limit(endPosition).collect(Collectors.toList());
        return resultList;
    }

}
