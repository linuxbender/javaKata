package ch.springBootRest.wildfly.api.v1.personInfo.repository;

import ch.springBootRest.wildfly.api.v1.personInfo.model.Person;
import ch.springBootRest.wildfly.api.v1.personInfo.model.PersonStateEnum;
import org.springframework.stereotype.Component;

@Component
public class PersonInfoRepository implements IPersonInfoRepository {

    private Person person;

    // Inject your data provider / adapter to replace the current mock
    public PersonInfoRepository() {
        this.person = this.getPersonData();
    }

    @Override
    public Person getPersonData() {
        // Mock - replace with your data provider / adapter
        // Immutable Person Builder for mapping your data
        return this.person = new Person.PersonBuilder("Jhon", "Doe")
                .age(42)
                .state(PersonStateEnum.ACTIVE)
                .build();
    }

    @Override
    public String getPersonName() {
        // call the context
        return String.format("%s %s %s", this.person.getFirstName(), this.person.getLastName(), this.person.getAge());
    }
}
