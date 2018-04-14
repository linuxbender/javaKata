package ch.springBootRest.wildfly.api.v1.translation;

import ch.springBootRest.wildfly.api.v1.translation.provider.TranslationService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/translation")
public class TranslationController {

    private final TranslationService translationService;

    public TranslationController(TranslationService translationService) {
        Assert.notNull(translationService, "translationService");
        this.translationService = translationService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{translationKey}/")
    public String actionTranslation(@PathVariable String translationKey){
        return this.translationService.getTranslation(translationKey);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{translationKey}/{replaceArgs}/")
    public String actionTranslationWithReplaceArgs(@PathVariable String translationKey, @PathVariable String... replaceArgs){
        return this.translationService.getTranslation(translationKey, replaceArgs);
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public Map<String, String> actionFullTranslation() {
        return this.translationService.getFullTranslation();
    }
}
