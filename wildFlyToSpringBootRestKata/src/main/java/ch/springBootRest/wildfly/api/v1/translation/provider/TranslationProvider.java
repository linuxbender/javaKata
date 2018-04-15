package ch.springBootRest.wildfly.api.v1.translation.provider;

import ch.springBootRest.wildfly.api.v1.translation.dto.TranslationDto;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Locale;

public interface TranslationProvider {

    TranslationDto getTranslation(String translationKey, @Nullable String... replaceArgs);

    Locale getLocale();

    List<TranslationDto> getFullTranslation();
}
