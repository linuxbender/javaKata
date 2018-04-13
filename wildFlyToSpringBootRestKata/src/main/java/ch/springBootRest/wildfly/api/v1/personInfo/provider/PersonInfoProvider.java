package ch.springBootRest.wildfly.api.v1.personInfo.provider;

import ch.springBootRest.wildfly.api.v1.personInfo.model.PersonInfo;

public interface PersonInfoProvider {

    String getPersonName();

    PersonInfo getPersonData();
}
