package ch.springBootRest.wildfly.api.v1.translation.dto;

import ch.springBootRest.wildfly.commen.Builder;
import org.springframework.lang.Nullable;

public class TranslationDto {

    private final String translationKey;
    private final String translationMessage;

    public TranslationDto(TranslationDtoBuilder translationDtoBuilder) {
        this.translationKey = translationDtoBuilder.translationKey;
        this.translationMessage = translationDtoBuilder.translationMessage;
    }

    public String getTranslationMessage() {
        return translationMessage;
    }

    public String getTranslationKey() {
        return translationKey;
    }

    public static class TranslationDtoBuilder implements Builder<TranslationDto> {

        private final String translationKey;
        private final String translationMessage;

        public TranslationDtoBuilder(@Nullable String translationKey, @Nullable String translationMessage) {
            this.translationKey = translationKey != null ? translationKey : "";
            this.translationMessage = translationMessage != null ? translationMessage : "";
        }

        public TranslationDto build() {
            return new TranslationDto(this);
        }
    }
}
