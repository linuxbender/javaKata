package ch.springBootRest.wildfly.api.v1.personInfo.provider;

import ch.springBootRest.wildfly.api.v1.personInfo.model.PersonInfo;
import ch.springBootRest.wildfly.api.v1.personInfo.model.PersonStateEnum;
import org.springframework.stereotype.Component;

@Component
public class PersonInfoProviderImpl implements PersonInfoProvider {

    private PersonInfo personInfo;

    // Inject your data provider / adapter to replace the current mock
    public PersonInfoProviderImpl() {
        this.personInfo = this.getPersonData();
    }

    @Override
    public PersonInfo getPersonData() {
        // Mock - replace with your data provider / adapter
        // Immutable PersonInfo Builder for mapping your data
        return this.personInfo = new PersonInfo.PersonBuilder("Jhon", "Doe")
                .age(42)
                .state(PersonStateEnum.ACTIVE)
                .build();
    }

    @Override
    public String getPersonName() {
        // call the context
        return String.format("%s %s %s", this.personInfo.getFirstName(), this.personInfo.getLastName(), this.personInfo.getAge());
    }
}
