package CustomFilter;


import java.util.*;

public class  CustomFilter<T> implements ICustomFilter<T>  {
    private List<T> updateList;

    public CustomFilter(List<T> list) {
        updateList = new ArrayList<>(list);
    }

    @Override
    public CustomFilter<T> filter(Check<T> check) {
        List<T> copyList = new ArrayList<>();
        for (T t : updateList) {
            if(check.Test(t))
                copyList.add(t);
        }
        updateList = copyList;
        return this;
    }

    @Override
    public List<T> format(int pageSize, int numberPage) {
        List<T> formatList = new ArrayList<>();
        for (int i = pageSize * (numberPage); i < pageSize * numberPage + pageSize; i++) {
            formatList.add(updateList.get(i));
        }
        return formatList;
    }

    @Override
    public List<T> format(int pageSize, int numberFirstPage, int numberLastPage) {
        List<T> formatList = new ArrayList<>();
        for (int i = pageSize * (numberFirstPage); i < pageSize * numberFirstPage + pageSize *(numberLastPage - numberFirstPage); i++) {
            formatList.add(updateList.get(i));
        }
        return formatList;
    }

    @Override
    public CustomFilter<T> sort(Comparator<T> comparator) {
        Collections.sort(updateList,comparator);
        return this;
    }

    @Override
    public List<T> getResult() {
        return updateList;
    }

    @Override
    public int count() {
        return updateList.size();
    }
}