package ch.springBootRest.wildfly.api.v1.personInfo.service;

import ch.springBootRest.wildfly.api.v1.personInfo.model.Person;
import ch.springBootRest.wildfly.api.v1.personInfo.model.PersonStateEnum;
import ch.springBootRest.wildfly.api.v1.personInfo.repository.IBaseDataRepository;
import ch.springBootRest.wildfly.api.v1.personInfo.repository.IPersonInfoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonInfoService implements IPersonInfoService {

    private final IPersonInfoRepository personInfoRepository;
    private final IBaseDataRepository baseDataRepository;

    public PersonInfoService(IPersonInfoRepository personInfoRepository, IBaseDataRepository baseDataRepository) {
        if (personInfoRepository == null) {
            throw new NullPointerException("personInfoRepository");
        }
        if (baseDataRepository == null) {
            throw new NullPointerException("baseDataRepository");
        }
        this.personInfoRepository = personInfoRepository;
        this.baseDataRepository = baseDataRepository;
    }

    @Override
    public String getPersonName() {
        return String.format("Hi..42 %s", this.personInfoRepository.getPersonName());
    }

    @Override
    public ArrayList<PersonStateEnum> getPersonStateCode() {
        return this.baseDataRepository.getPersonStateCode();
    }

    @Override
    public String isCurrentPersonActiv() {
        Person currentPerson = this.personInfoRepository.getPersonData();
        return currentPerson.getPersonStateEnum() == PersonStateEnum.ACTIVE ? PersonStateEnum.ACTIVE.state(): PersonStateEnum.INACTIVE.state();
    }

    @Override
    public boolean isStateCountValid() {
        return this.baseDataRepository.getStateCount() == 2;
    }
}
