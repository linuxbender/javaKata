package ch.springBootRest.wildfly.api.v1.personInfo.model;

public enum PersonStateEnum {
    ACTIVE("Person is Active"),
    INACTIVE("Person is Inactive");

    private String personState;

    PersonStateEnum(String personState) {
        this.personState = personState;
    }

    public String state() {
        return personState;
    }
}
