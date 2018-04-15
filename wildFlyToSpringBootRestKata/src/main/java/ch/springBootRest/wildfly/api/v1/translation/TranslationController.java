package ch.springBootRest.wildfly.api.v1.translation;

import ch.springBootRest.wildfly.api.v1.translation.provider.TranslationProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translation")
public class TranslationController {

    private final TranslationProvider translationProvider;

    public TranslationController(TranslationProvider translationProvider) {
        Assert.notNull(translationProvider, "translationProvider");
        this.translationProvider = translationProvider;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{translationKey}")
    public ResponseEntity<?> actionTranslation(@PathVariable String translationKey) {
        return ResponseEntity.ok(this.translationProvider.getTranslation(translationKey));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{translationKey}/{replaceArgs}")
    public ResponseEntity<?> actionTranslationWithReplaceArgs(@PathVariable String translationKey, @PathVariable String... replaceArgs) {
        return ResponseEntity.ok(this.translationProvider.getTranslation(translationKey, replaceArgs));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> actionFullTranslation() {
        return ResponseEntity.ok(this.translationProvider.getFullTranslation());
    }
}
