package ch.springBootRest.wildfly.error;

import ch.springBootRest.wildfly.commen.Builder;

public class Error {

    private final String dtoName;
    private final String field;
    private final String message;

    public Error(ErrorBuilder errorBuilder) {
        this.dtoName = errorBuilder.dtoName;
        this.field = errorBuilder.field;
        this.message = errorBuilder.message;
    }

    public String getDtoName() {
        return dtoName;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

    public static class ErrorBuilder implements Builder<Error> {

        private final String dtoName;
        private final String field;
        private final String message;

        public ErrorBuilder(String dtoName, String field, String message) {
            this.dtoName = dtoName;
            this.field = field;
            this.message = message;
        }

        @Override
        public Error build() {
            return new Error(this);
        }
    }
}
