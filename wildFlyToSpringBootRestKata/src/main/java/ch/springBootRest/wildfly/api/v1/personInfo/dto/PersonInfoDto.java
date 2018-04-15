package ch.springBootRest.wildfly.api.v1.personInfo.dto;

import ch.springBootRest.wildfly.commen.Builder;

public class PersonInfoDto {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final PersonStateEnum personStateEnum;

    public PersonInfoDto(PersonInfoBuilder personInfoBuilder) {
        this.firstName = personInfoBuilder.firstName;
        this.lastName = personInfoBuilder.lastName;
        this.age = personInfoBuilder.age;
        this.personStateEnum = personInfoBuilder.personStateEnum;
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

    public static class PersonInfoBuilder implements Builder<PersonInfoDto> {
        private final String firstName;
        private final String lastName;
        private int age;
        private PersonStateEnum personStateEnum;

        public PersonInfoBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public PersonInfoBuilder state(PersonStateEnum personStateEnum) {
            this.personStateEnum = personStateEnum;
            return this;
        }

        public PersonInfoBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonInfoDto build() {
            return new PersonInfoDto(this);
        }
    }
}
