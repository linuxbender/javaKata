package ch.springBootRest.wildfly.api.v1.personInfo.provider;

import ch.springBootRest.wildfly.api.v1.personInfo.dto.PersonStateEnum;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BaseDataProviderImpl implements BaseDataProvider {

    private ArrayList<PersonStateEnum> personStateEnumArrayListDto;

    // Inject your data provider / adapter to replace the current mock
    public BaseDataProviderImpl() {
        this.personStateEnumArrayListDto = new ArrayList<>();
        personStateEnumArrayListDto.add(PersonStateEnum.ACTIVE);
        personStateEnumArrayListDto.add(PersonStateEnum.INACTIVE);
    }

    @Override
    public ArrayList<PersonStateEnum> getPersonStateCode() {
        return this.personStateEnumArrayListDto;
    }

    @Override
    public int getStateCount() {
        return this.personStateEnumArrayListDto.size();
    }
}
