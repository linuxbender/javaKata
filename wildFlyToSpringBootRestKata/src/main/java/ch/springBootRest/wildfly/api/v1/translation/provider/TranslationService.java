package ch.springBootRest.wildfly.api.v1.translation.provider;
import org.springframework.lang.Nullable;

import java.util.Locale;
import java.util.Map;

public interface TranslationService {

    String getTranslation(String translationKey,@Nullable String... replaceArgs);

    Locale getLocale();

    Map<String, String> getFullTranslation();
}
