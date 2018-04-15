package ch.springBootRest.wildfly.error;

public class Dto {
    private final String dto;
    private final Object values;

    public Dto(String dto, Object values) {
        this.dto = dto;
        this.values = values;
    }
}
