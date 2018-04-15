package ch.springBootRest.wildfly.api.v1.personInfo.provider;

import ch.springBootRest.wildfly.api.v1.personInfo.dto.PersonInfoDto;
import ch.springBootRest.wildfly.api.v1.personInfo.dto.PersonStateEnum;
import org.springframework.stereotype.Component;

@Component
public class PersonInfoProviderImpl implements PersonInfoProvider {

    private PersonInfoDto personInfoDto;

    // Inject your data provider / adapter to replace the current mock
    public PersonInfoProviderImpl() {
        this.personInfoDto = this.getPersonData();
    }

    @Override
    public PersonInfoDto getPersonData() {
        // Mock - replace with your data provider / adapter
        // Immutable PersonInfoDto Builder for mapping your data
        return this.personInfoDto = new PersonInfoDto.PersonInfoBuilder("Jhon", "Doe")
                .age(42)
                .state(PersonStateEnum.ACTIVE)
                .build();
    }

    @Override
    public String getPersonName() {
        // call the context
        return String.format("%s %s %s", this.personInfoDto.getFirstName(), this.personInfoDto.getLastName(), this.personInfoDto.getAge());
    }
}
