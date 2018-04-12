package ch.springBootRest.ch.springBootRest.wildfly.api.v1.personInfo;

import ch.springBootRest.ch.springBootRest.wildfly.api.v1.personInfo.repository.IPersonInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonInfoService implements IPersonInfoService {

    private IPersonInfoRepository personInfoRepository;

    @Autowired
    public PersonInfoService(IPersonInfoRepository personInfoService) {
        this.personInfoRepository = personInfoService;
    }

    @Override
    public String getPersonName() {
        return String.format("Hi..42 %s", this.personInfoRepository.getPersonName());
    }
}
