package ch.springBootRest.wildfly.api.v1.translation;

import ch.springBootRest.wildfly.api.v1.translation.dto.TranslationDto;
import ch.springBootRest.wildfly.api.v1.translation.provider.TranslationProvider;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/translation")
public class TranslationController {

    private final TranslationProvider translationProvider;

    public TranslationController(TranslationProvider translationProvider) {
        Assert.notNull(translationProvider, "translationProvider");
        this.translationProvider = translationProvider;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{translationKey}")
    public TranslationDto actionTranslation(@PathVariable String translationKey) {
        return this.translationProvider.getTranslation(translationKey);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{translationKey}/{replaceArgs}")
    public TranslationDto actionTranslationWithReplaceArgs(@PathVariable String translationKey, @PathVariable String... replaceArgs) {
        return this.translationProvider.getTranslation(translationKey, replaceArgs);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TranslationDto> actionFullTranslation() {
        return this.translationProvider.getFullTranslation();
    }
}
