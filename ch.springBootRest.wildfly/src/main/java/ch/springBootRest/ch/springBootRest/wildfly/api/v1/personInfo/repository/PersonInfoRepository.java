package ch.springBootRest.ch.springBootRest.wildfly.api.v1.personInfo.repository;

import ch.springBootRest.ch.springBootRest.wildfly.api.v1.personInfo.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonInfoRepository implements IPersonInfoRepository {

    private Person person;

    public PersonInfoRepository() {
        this.person = this.getPersonData();
    }

    public Person getPersonData() {
        // Mock - replace with your DataContext
        return this.person = new Person.PersonBuilder("Jhon", "Doe")
                .age(42)
                .build();
    }


    @Override
    public String getPersonName() {
        // call the context
        return String.format("%s %s %s", this.person.getFirstName(), this.person.getLastName(), this.person.getAge());
    }
}
