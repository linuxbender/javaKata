package ch.springBootRest.ch.springBootRest.wildfly.api.v1.personInfo;

import ch.springBootRest.ch.springBootRest.wildfly.api.v1.personInfo.repository.IPersonInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonInfoService implements IPersonInfoService {

    private IPersonInfoRepository personInfoRepository;

    public PersonInfoService(IPersonInfoRepository personInfoRepository) {
        if (personInfoRepository == null) {
            throw new NullPointerException("personInfoRepository");
        }
        this.personInfoRepository = personInfoRepository;
    }

    @Override
    public String getPersonName() {
        return String.format("Hi..42 %s", this.personInfoRepository.getPersonName());
    }
}
