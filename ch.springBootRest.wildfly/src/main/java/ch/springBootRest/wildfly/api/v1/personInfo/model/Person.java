package ch.springBootRest.wildfly.api.v1.personInfo.model;

import ch.springBootRest.wildfly.IBuilder;

public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final PersonStateEnum personStateEnum;

    public Person(PersonBuilder personBuilder) {
        this.firstName = personBuilder.firstName;
        this.lastName = personBuilder.lastName;
        this.age = personBuilder.age;
        this.personStateEnum = personBuilder.personStateEnum;
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

    public PersonStateEnum getPersonStateEnum() {
        return personStateEnum;
    }

    public static class PersonBuilder implements IBuilder<Person> {
        private final String firstName;
        private final String lastName;
        private int age;
        private PersonStateEnum personStateEnum;

        public PersonBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public PersonBuilder state(PersonStateEnum personStateEnum) {
            this.personStateEnum = personStateEnum;
            return this;
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
