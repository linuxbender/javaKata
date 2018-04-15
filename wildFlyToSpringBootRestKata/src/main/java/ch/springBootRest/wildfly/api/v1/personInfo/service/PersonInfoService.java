package ch.springBootRest.wildfly.api.v1.personInfo.service;

import ch.springBootRest.wildfly.api.v1.personInfo.dto.PersonStateEnum;

import java.util.ArrayList;

public interface PersonInfoService {
    String getPersonName();

    ArrayList<PersonStateEnum> getPersonStateCode();
    String isCurrentPersonActiv();
    boolean isStateCountValid();
}
