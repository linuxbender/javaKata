package ch.springBootRest.wildfly.api.v1.personInfo.dto;

import ch.springBootRest.wildfly.commen.Builder;

public class PersonInfoDto {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final PersonStateEnumDto personStateEnumDto;

    public PersonInfoDto(PersonInfoBuilder personInfoBuilder) {
        this.firstName = personInfoBuilder.firstName;
        this.lastName = personInfoBuilder.lastName;
        this.age = personInfoBuilder.age;
        this.personStateEnumDto = personInfoBuilder.personStateEnumDto;
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

    public PersonStateEnumDto getPersonStateEnumDto() {
        return personStateEnumDto;
    }

    public static class PersonInfoBuilder implements Builder<PersonInfoDto> {
        private final String firstName;
        private final String lastName;
        private int age;
        private PersonStateEnumDto personStateEnumDto;

        public PersonInfoBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public PersonInfoBuilder state(PersonStateEnumDto personStateEnumDto) {
            this.personStateEnumDto = personStateEnumDto;
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
