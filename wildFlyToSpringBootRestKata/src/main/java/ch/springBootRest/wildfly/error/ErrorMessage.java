package ch.springBootRest.wildfly.error;

import ch.springBootRest.wildfly.commen.Builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorMessage {

    private final Date timestamp;
    private final int status;
    private final String errorType;
    private List<Error> errors = new ArrayList<>();
    private final Dto modelBinder;

    public ErrorMessage(int status, String errorType, Dto modelBinder) {
        this.timestamp = new Date();
        this.status = status;
        this.errorType = errorType;
        this.modelBinder = modelBinder;
    }

    public ErrorMessage(ErrorMessageBuilder errorMessageBuilder) {
        this.timestamp = new Date();
        this.status = errorMessageBuilder.status;
        this.errorType = errorMessageBuilder.errorType;
        this.modelBinder = errorMessageBuilder.modelBinder;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return errorType;
    }

    public void addError(String dtoName, String field, String message) {
        this.errors.add(new Error.ErrorBuilder(dtoName, field, message).build());
    }

    public List<Error> getFieldErrors() {
        return errors;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Dto getModelBinder() {
        return modelBinder;
    }

    public static class ErrorMessageBuilder implements Builder<ErrorMessage> {

        public final int status;
        public final String errorType;
        public final Dto modelBinder;

        public ErrorMessageBuilder(int status, String errorType, Dto modelBinder) {
            this.status = status;
            this.errorType = errorType;
            this.modelBinder = modelBinder;
        }

        @Override
        public ErrorMessage build() {
            return new ErrorMessage(this);
        }
    }
}
