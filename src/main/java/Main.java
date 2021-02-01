

import Model.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        Person person = new Person(13,"I", Person.Gender.man);
        System.out.println(person);




    }
}
