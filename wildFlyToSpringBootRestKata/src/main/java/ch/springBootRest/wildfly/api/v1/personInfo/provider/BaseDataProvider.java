package ch.springBootRest.wildfly.api.v1.personInfo.provider;

import ch.springBootRest.wildfly.api.v1.personInfo.dto.PersonStateEnum;

import java.util.ArrayList;

public interface BaseDataProvider {
    ArrayList<PersonStateEnum> getPersonStateCode();
    int getStateCount();
}
