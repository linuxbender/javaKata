package ch.springBootRest.wildfly.api.v1.personInfo.model;

public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;

    public Person(PersonBuilder personBuilder) {
        this.firstName = personBuilder.firstName;
        this.lastName = personBuilder.lastName;
        this.age = personBuilder.age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public static class PersonBuilder implements IBuilder<Person> {
        private final String firstName;
        private final String lastName;
        private int age;

        public PersonBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
