package ch.springBootRest.wildfly.api.v1.person.dto;

import ch.springBootRest.wildfly.commen.Builder;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonDto {

    private final Long id;

    @NotNull(message = "{validation-notNull}")
    @Size(min = 3, max = 30, message = "{validation-size}")
    private final String firstName;

    @NotNull(message = "{validation-notNull}")
    @Size(min = 3, max = 30, message = "{validation-size}")
    private final String lastName;

    public PersonDto(PersonBuilder personBuilder) {
        this.id = personBuilder.id;
        this.firstName = personBuilder.firstName;
        this.lastName = personBuilder.lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class PersonBuilder implements Builder<PersonDto> {
        private final Long id;
        private final String firstName;
        private final String lastName;

        public PersonBuilder(@Nullable Long id, @Nullable String firstName, @Nullable String lastName) {
            this.id = id;
            this.firstName = firstName != null ? firstName : "";
            ;
            this.lastName = lastName != null ? lastName : "";
            ;
        }

        public PersonDto build() {
            return new PersonDto(this);
        }
    }
}
