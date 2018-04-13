package ch.springBootRest.wildfly.api.v1.personInfo.service;

import ch.springBootRest.wildfly.api.v1.personInfo.model.PersonStateEnum;

import java.util.ArrayList;

public interface PersonInfoService {
    String getPersonName();
    ArrayList<PersonStateEnum> getPersonStateCode();
    String isCurrentPersonActiv();
    boolean isStateCountValid();
}
