package ch.springBootRest.wildfly.api.v1.personInfo.service;

import ch.springBootRest.wildfly.api.v1.personInfo.model.PersonInfo;
import ch.springBootRest.wildfly.api.v1.personInfo.model.PersonStateEnum;
import ch.springBootRest.wildfly.api.v1.personInfo.provider.BaseDataProvider;
import ch.springBootRest.wildfly.api.v1.personInfo.provider.PersonInfoProvider;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

    private final PersonInfoProvider personInfoProvider;
    private final BaseDataProvider baseDataProvider;

    public PersonInfoServiceImpl(PersonInfoProvider personInfoProvider, BaseDataProvider baseDataProvider) {
        if (personInfoProvider == null) {
            throw new NullPointerException("personInfoProvider");
        }
        if (baseDataProvider == null) {
            throw new NullPointerException("baseDataProvider");
        }
        this.personInfoProvider = personInfoProvider;
        this.baseDataProvider = baseDataProvider;
    }

    @Override
    public String getPersonName() {
        return String.format("Hi..42 %s", this.personInfoProvider.getPersonName());
    }

    @Override
    public ArrayList<PersonStateEnum> getPersonStateCode() {
        return this.baseDataProvider.getPersonStateCode();
    }

    @Override
    public String isCurrentPersonActiv() {
        PersonInfo currentPersonInfo = this.personInfoProvider.getPersonData();
        return currentPersonInfo.getPersonStateEnum() == PersonStateEnum.ACTIVE ? PersonStateEnum.ACTIVE.state() : PersonStateEnum.INACTIVE.state();
    }

    @Override
    public boolean isStateCountValid() {
        return this.baseDataProvider.getStateCount() == 2;
    }
}
