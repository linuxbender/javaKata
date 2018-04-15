package ch.springBootRest.wildfly.error;

public enum ErrorTypeEnum {

    ERROR_TYPE_BUSINESS_EXECTION("ERROR_TYPE_BUSINESS_EXECTION");

    private String errorType;

    ErrorTypeEnum(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorType() {
        return errorType;
    }
}
