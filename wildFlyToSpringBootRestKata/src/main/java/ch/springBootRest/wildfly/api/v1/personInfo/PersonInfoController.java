package ch.springBootRest.wildfly.api.v1.personInfo;

import ch.springBootRest.wildfly.api.v1.personInfo.service.PersonInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/personinfo")
public class PersonInfoController {

    private final PersonInfoService personInfoService;

    public PersonInfoController(PersonInfoService personInfoService) {
        Assert.notNull(personInfoService, "personInfoService");
        this.personInfoService = personInfoService;
    }

    @GetMapping
    public ResponseEntity<?> actionFullPersonName() {
        return ResponseEntity.ok(this.personInfoService.getPersonName());
    }

    @GetMapping
    @RequestMapping("/{personName}")
    public ResponseEntity<?> actionFullPersonName(@PathVariable String personName) {
        return ResponseEntity.ok(String.format("Hi, %s", personName));
    }

    @GetMapping
    @RequestMapping("/person-states")
    public ResponseEntity<?> actionPersonStates() {
        return ResponseEntity.ok(this.personInfoService.getPersonStateCode());
    }

    @GetMapping
    @RequestMapping("/current-person-state")
    public ResponseEntity<?> actionCurrentPersonState() {
        return ResponseEntity.ok(this.personInfoService.isCurrentPersonActiv());
    }

    @GetMapping
    @RequestMapping("/is-state-count-valid")
    public ResponseEntity<?> isStateCountValid() {
        return ResponseEntity.ok(this.personInfoService.isStateCountValid());
    }

    @GetMapping
    @RequestMapping("/current-date")
    public ResponseEntity<?> actionCurrentDate() {
        return ResponseEntity.ok(new Date());
    }
}
