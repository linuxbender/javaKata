package ch.springBootRest.wildfly.api.v1.personInfo.repository;

import ch.springBootRest.wildfly.api.v1.personInfo.model.Person;

public interface IPersonInfoRepository {

    String getPersonName();

    Person getPersonData();
}
