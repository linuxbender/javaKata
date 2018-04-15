package ch.springBootRest.wildfly.api.v1.personInfo.service;

import ch.springBootRest.wildfly.api.v1.personInfo.dto.PersonInfoDto;
import ch.springBootRest.wildfly.api.v1.personInfo.dto.PersonStateEnumDto;
import ch.springBootRest.wildfly.api.v1.personInfo.provider.BaseDataProvider;
import ch.springBootRest.wildfly.api.v1.personInfo.provider.PersonInfoProvider;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

    private final PersonInfoProvider personInfoProvider;
    private final BaseDataProvider baseDataProvider;

    public PersonInfoServiceImpl(PersonInfoProvider personInfoProvider, BaseDataProvider baseDataProvider) {

        Assert.notNull(personInfoProvider, "personInfoProvider");
        Assert.notNull(baseDataProvider, "baseDataProvider");

        this.personInfoProvider = personInfoProvider;
        this.baseDataProvider = baseDataProvider;
    }

    @Override
    public String getPersonName() {
        return String.format("Hi..42 %s", this.personInfoProvider.getPersonName());
    }

    @Override
    public ArrayList<PersonStateEnumDto> getPersonStateCode() {
        return this.baseDataProvider.getPersonStateCode();
    }

    @Override
    public String isCurrentPersonActiv() {
        PersonInfoDto currentPersonInfoDto = this.personInfoProvider.getPersonData();
        return currentPersonInfoDto.getPersonStateEnumDto() == PersonStateEnumDto.ACTIVE ? PersonStateEnumDto.ACTIVE.state() : PersonStateEnumDto.INACTIVE.state();
    }

    @Override
    public boolean isStateCountValid() {
        return this.baseDataProvider.getStateCount() == 2;
    }
}
