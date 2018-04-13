package ch.springBootRest.wildfly.api.v1.personInfo.repository;

import ch.springBootRest.wildfly.api.v1.personInfo.model.PersonStateEnum;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BaseDataRepository implements IBaseDataRepository {

    private ArrayList<PersonStateEnum> personStateEnumArrayList;

    // Inject your data provider / adapter to replace the current mock
    public BaseDataRepository() {
        this.personStateEnumArrayList = new ArrayList<>();
        personStateEnumArrayList.add(PersonStateEnum.ACTIVE);
        personStateEnumArrayList.add(PersonStateEnum.INACTIVE);
    }

    @Override
    public ArrayList<PersonStateEnum> getPersonStateCode() {
        return this.personStateEnumArrayList;
    }

    @Override
    public int getStateCount() {
        return this.personStateEnumArrayList.size();
    }
}
