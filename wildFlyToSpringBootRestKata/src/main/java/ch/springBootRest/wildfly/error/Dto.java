package ch.springBootRest.wildfly.error;

import ch.springBootRest.wildfly.commen.Builder;

public class Dto {

    private final String dtoName;
    private final Object values;

    public Dto(DtoBuilder dtoBuilder) {
        this.dtoName = dtoBuilder.dtoName;
        this.values = dtoBuilder.values;
    }

    public String getDtoName() {
        return dtoName;
    }

    public Object getValues() {
        return values;
    }

    public static class DtoBuilder implements Builder<Dto> {

        private final String dtoName;
        private final Object values;

        public DtoBuilder(String dtoName, Object values) {
            this.dtoName = dtoName;
            this.values = values;
        }

        @Override
        public Dto build() {
            return new Dto(this);
        }
    }
}
