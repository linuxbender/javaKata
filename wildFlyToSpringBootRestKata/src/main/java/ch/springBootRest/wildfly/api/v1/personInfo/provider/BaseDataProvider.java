package ch.springBootRest.wildfly.api.v1.personInfo.provider;

import ch.springBootRest.wildfly.api.v1.personInfo.dto.PersonStateEnumDto;

import java.util.ArrayList;

public interface BaseDataProvider {
    ArrayList<PersonStateEnumDto> getPersonStateCode();
    int getStateCount();
}
