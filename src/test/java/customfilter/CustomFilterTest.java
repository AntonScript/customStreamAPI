package customfilter;

import Model.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomFilterTest {
    private  List<Person> personList;
    ICustomFilter <Person> customFilter;

    @Before
    public void setUp() throws Exception {
        personList = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            personList.add(new Person(i,"name" + i,i%2==0 ? Person.Gender.woman : Person.Gender.man));
        }
        customFilter = new CustomFilter<>(personList);
    }

    @Test
    public void filter() {
        List<Person> testList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if(i%2 != 0)
                testList.add(new Person(i,"name" + i, Person.Gender.man));
        }
        List<Person> resList = customFilter.filter(person -> person.getGender().equals("man")).getResult();
        assertEquals(testList,resList);
        
    }

    @Test
    public void formatOnePage() {
        int pageLimit = 5;
        int numberPage = 5;
        for (int count = 0; count < 3; count++) {
            pageLimit+=count;
            numberPage+=count;
            List<Person> testList = new ArrayList<>();
            for (int i = pageLimit * (numberPage); i < pageLimit * numberPage + pageLimit; i++) {
                testList.add(new Person(i,"name" + i,i%2==0 ? Person.Gender.woman : Person.Gender.man));
            }
            List<Person> resList = customFilter.paginate(pageLimit,numberPage);
            assertEquals(testList,resList);
        }
    }

    @Test
    public void format() {
        int pageLimit = 5;
        int numberFirstPage = 3;
        int numberLastPage = 5;
        for (int count = 0; count < 3; count++) {
            pageLimit+=count;
            numberFirstPage+=count;
            List<Person> testList = new ArrayList<>();
            for (int i = pageLimit * (numberFirstPage); i < pageLimit * numberFirstPage + pageLimit *(numberLastPage - numberFirstPage); i++) {
                testList.add(new Person(i,"name" + i,i%2==0 ? Person.Gender.woman : Person.Gender.man));
            }
            List<Person> resList = customFilter.paginate(pageLimit,numberFirstPage,numberLastPage);
            assertEquals(testList,resList);
        }

    }


    @Test()
    public void getResult() {
        List<Person> resList = customFilter.getResult();
        assertEquals(resList,personList);
        resList = customFilter.filter(person -> person.getAge() > 5).getResult();
        assertNotEquals(resList,personList);
    }

    @Test
    public void count() {
        int result = customFilter.count();
        assertEquals(result,personList.size());
        result = customFilter.filter(person -> person.getGender().equals("man")).count();
        assertEquals(result,personList.size() / 2);

    }
}
