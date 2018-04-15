package ch.springBootRest.wildfly.api.v1.personInfo.service;

import ch.springBootRest.wildfly.api.v1.personInfo.dto.PersonStateEnumDto;

import java.util.ArrayList;

public interface PersonInfoService {
    String getPersonName();

    ArrayList<PersonStateEnumDto> getPersonStateCode();
    String isCurrentPersonActiv();
    boolean isStateCountValid();
}
