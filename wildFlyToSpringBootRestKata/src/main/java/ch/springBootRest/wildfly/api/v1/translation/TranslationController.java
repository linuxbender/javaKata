package ch.springBootRest.wildfly.api.v1.translation;

import ch.springBootRest.wildfly.api.v1.translation.dto.TranslationDto;
import ch.springBootRest.wildfly.api.v1.translation.provider.TranslationService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/translation")
public class TranslationController {

    private final TranslationService translationService;

    public TranslationController(TranslationService translationService) {
        Assert.notNull(translationService, "translationService");
        this.translationService = translationService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{translationKey}")
    public TranslationDto actionTranslation(@PathVariable String translationKey) {
        return this.translationService.getTranslation(translationKey);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{translationKey}/{replaceArgs}")
    public TranslationDto actionTranslationWithReplaceArgs(@PathVariable String translationKey, @PathVariable String... replaceArgs) {
        return this.translationService.getTranslation(translationKey, replaceArgs);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TranslationDto> actionFullTranslation() {
        return this.translationService.getFullTranslation();
    }
}
