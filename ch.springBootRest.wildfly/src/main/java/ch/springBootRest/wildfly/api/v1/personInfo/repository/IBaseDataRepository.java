package ch.springBootRest.wildfly.api.v1.personInfo.repository;

import ch.springBootRest.wildfly.api.v1.personInfo.model.PersonStateEnum;

import java.util.ArrayList;

public interface IBaseDataRepository {
    ArrayList<PersonStateEnum> getPersonStateCode();
    int getStateCount();
}
