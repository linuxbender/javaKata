package ch.springBootRest.wildfly.api.v1.translation.provider;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

@Service
public class TranslationServiceImpl implements TranslationService {

    private final MessageSource messageSource;
    private String bundleName;

    public TranslationServiceImpl(MessageSource messageSource) {
        Assert.notNull(messageSource, "messageSource");
        this.messageSource = messageSource;
        setBundleName("i18n/app");
    }

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundelName) {
        Assert.notNull(bundelName, "bundelName");
        this.bundleName = bundelName;
    }

    @Override
    public String getTranslation(String translationKey, @Nullable String... arg) {
        try{
            return this.messageSource.getMessage(translationKey, arg, getLocale());
        } catch (NoSuchMessageException e){

        }
        return "";
    }

    @Override
    public Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

    @Override
    public Map<String, String> getFullTranslation() {
        ResourceBundle bundle = ResourceBundle.getBundle(getBundleName(), getLocale());
        return convertToMap(bundle);
    }

    private Map<String, String> convertToMap(ResourceBundle resource) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            map.put(key, resource.getString(key));
        }
        return map;
    }
}
