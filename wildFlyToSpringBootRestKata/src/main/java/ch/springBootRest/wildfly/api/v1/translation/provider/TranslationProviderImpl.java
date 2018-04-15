package ch.springBootRest.wildfly.api.v1.translation.provider;

import ch.springBootRest.wildfly.api.v1.translation.dto.TranslationDto;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.*;

@Component
public class TranslationProviderImpl implements TranslationProvider {

    private final MessageSource messageSource;
    private String bundleName;

    public TranslationProviderImpl(MessageSource messageSource) {
        Assert.notNull(messageSource, "messageSource");

        this.messageSource = messageSource;
        setBundleName("messages");
    }

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundelName) {
        Assert.notNull(bundelName, "bundelName");
        this.bundleName = bundelName;
    }

    @Override
    public TranslationDto getTranslation(String translationKey, @Nullable String... arg) {
        TranslationDto translationDto = new TranslationDto.
                TranslationDtoBuilder(translationKey, null).build();
        try {
            String message = this.messageSource.getMessage(translationKey, arg, getLocale());
            translationDto = new TranslationDto.TranslationDtoBuilder(translationKey, message).build();
        } catch (NoSuchMessageException e) {
            // todo spring boot exception handling
        }
        return translationDto;
    }

    @Override
    public Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

    @Override
    public List<TranslationDto> getFullTranslation() {
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle(getBundleName(), getLocale());
        } catch (MissingResourceException e) {
            // todo spring boot exception handling
        }
        return convertToList(bundle);
    }

    private List<TranslationDto> convertToList(ResourceBundle resource) {
        List<TranslationDto> translationList = new ArrayList<>();
        if (resource != null) {
            Enumeration<String> resourceKeys = resource.getKeys();
            while (resourceKeys.hasMoreElements()) {
                String key = resourceKeys.nextElement();
                translationList.add(new TranslationDto.TranslationDtoBuilder(key, resource.getString(key)).build());
            }
        }
        return translationList;
    }
}
