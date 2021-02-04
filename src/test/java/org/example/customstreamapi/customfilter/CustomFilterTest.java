package org.example.customstreamapi.customfilter;

import org.example.customstreamapi.model.Gender;
import org.example.customstreamapi.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CustomFilterTest {
    private List<Person> personList;
    ICustomFilter <Person> customFilter;

    @Before
    public void setUp() throws Exception {
        personList = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            personList.add(new Person(i,"name" + i,i%2==0 ? Gender.woman : Gender.man));
        }
        customFilter = new CustomFilter<Person>();
    }

    @Test
    public void filter() {
        List<Person> testList = new ArrayList<>();

        List<Person> resList = customFilter.filter(personList,person -> person.getAge() < 50);
        assertEquals(50,resList.size());

    }

    @Test
    public void formatOnePage() {
        int pageLimit = 5;
        int numberPage = 5;
        List<Person> testList = new ArrayList<>();
        for (int i = pageLimit * (numberPage-1); i < pageLimit * numberPage; i++) {
            testList.add(new Person(i,"name" + i,i%2==0 ? Gender.woman : Gender.man));
        }
        List<Person> resList = customFilter.paginate(personList,pageLimit,numberPage);
        assertEquals(testList,resList);
    }

    @Test
    public void format() {
        int pageLimit = 5;
        int numberFirstPage = 3;
        int numberLastPage = 5;
        int startPosition = pageLimit * (numberFirstPage-1);
        int endPosition = pageLimit * numberLastPage;
        List<Person> testList = new ArrayList<>();
        for (int i = startPosition; i < endPosition; i++) {
            testList.add(new Person(i,"name" + i,i%2==0 ? Gender.woman : Gender.man));
        }
        List<Person> resList = customFilter.paginate(personList,pageLimit,numberFirstPage,numberLastPage);
        assertEquals(testList,resList);



    }


    @Test()
    public void getResult() {
        List<Person> resList = personList;
        assertEquals(resList,personList);
        resList = customFilter.filter(personList,person -> person.getAge() > 5);
        assertNotEquals(resList,personList);
    }


}
