package ch.springBootRest.wildfly.api.v1.personInfo.dto;

public enum PersonStateEnum {
    ACTIVE("PersonInfoDto is Active"),
    INACTIVE("PersonInfoDto is Inactive");

    private String personState;

    PersonStateEnum(String personState) {
        this.personState = personState;
    }

    public String state() {
        return personState;
    }
}
