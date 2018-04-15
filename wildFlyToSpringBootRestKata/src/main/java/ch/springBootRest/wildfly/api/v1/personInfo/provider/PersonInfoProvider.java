package ch.springBootRest.wildfly.api.v1.personInfo.provider;

import ch.springBootRest.wildfly.api.v1.personInfo.dto.PersonInfoDto;

public interface PersonInfoProvider {

    String getPersonName();

    PersonInfoDto getPersonData();
}
