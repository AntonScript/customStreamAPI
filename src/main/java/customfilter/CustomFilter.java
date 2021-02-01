package customfilter;


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
            if(check.test(t))
                copyList.add(t);
        }
        updateList = copyList;
        return this;
    }

    @Override
    public List<T> paginate(int pageSize, int numberPage) {
        List<T> formatList = new ArrayList<>();
        int startPosition = pageSize * numberPage;
        int endPosition = pageSize * numberPage + pageSize;
        for (int i = startPosition; i < endPosition; i++) {
            formatList.add(updateList.get(i));
        }
        return formatList;
    }

    @Override
    public List<T> paginate(int pageSize, int numberFirstPage, int numberLastPage) {
        List<T> formatList = new ArrayList<>();
        int startPosition = pageSize * numberFirstPage;
        int endPosition = pageSize * numberFirstPage + pageSize *(numberLastPage - numberFirstPage);
        for (int i = startPosition; i < endPosition; i++) {
            formatList.add(updateList.get(i));
        }
        return formatList;
    }

    @Override
    public List<T> sort(Comparator<T> comparator) {
        Collections.sort(updateList,comparator);
        return updateList;
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