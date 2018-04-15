package ch.springBootRest.wildfly.api.v1.personInfo.provider;

import ch.springBootRest.wildfly.api.v1.personInfo.dto.PersonStateEnumDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BaseDataProviderImpl implements BaseDataProvider {

    private ArrayList<PersonStateEnumDto> personStateEnumArrayListDto;

    // Inject your data provider / adapter to replace the current mock
    public BaseDataProviderImpl() {
        this.personStateEnumArrayListDto = new ArrayList<>();
        personStateEnumArrayListDto.add(PersonStateEnumDto.ACTIVE);
        personStateEnumArrayListDto.add(PersonStateEnumDto.INACTIVE);
    }

    @Override
    public ArrayList<PersonStateEnumDto> getPersonStateCode() {
        return this.personStateEnumArrayListDto;
    }

    @Override
    public int getStateCount() {
        return this.personStateEnumArrayListDto.size();
    }
}
