package ch.springBootRest.wildfly.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorMessage {
    private final Date timestamp;
    private final int status;
    private final String errorType;
    private List<Error> errors = new ArrayList<>();
    private final Dto modelBinder;

    ErrorMessage(int status, String errorType, Dto modelBinder) {
        this.timestamp = new Date();
        this.status = status;
        this.errorType = errorType;
        this.modelBinder = modelBinder;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return errorType;
    }

    public void addError(String dtoName, String field, String message) {
        Error error = new Error(dtoName, field, message);
        this.errors.add(error);
    }

    public List<Error> getFieldErrors() {
        return errors;
    }
}
