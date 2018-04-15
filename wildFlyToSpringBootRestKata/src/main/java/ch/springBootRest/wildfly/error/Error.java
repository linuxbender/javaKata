package ch.springBootRest.wildfly.error;

public class Error {
    private final String dtoName;
    private final String field;
    private final String message;

    public Error(String dtoName, String field, String message) {
        this.dtoName = dtoName;
        this.field = field;
        this.message = message;
    }
}
