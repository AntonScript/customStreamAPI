package Model;

import java.util.Objects;

public class Person {
    private int age;
    private String name;
    private String gender;


    public Person() {
    }

    public Person(int age, String name, Gender gender) {
        this.age = age;
        this.name = name;
        this.gender = gender.getGender();
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public enum Gender{
        woman("woman"),
        man("man");

        private final String gender;

        Gender(String gender) {
            this.gender = gender;
        }

        public String getGender() {
            return gender;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && gender == person.gender && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, gender);
    }
}