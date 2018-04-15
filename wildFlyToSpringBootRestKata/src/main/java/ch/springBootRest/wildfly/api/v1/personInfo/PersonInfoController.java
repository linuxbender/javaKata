package ch.springBootRest.wildfly.api.v1.personInfo;

import ch.springBootRest.wildfly.api.v1.personInfo.service.PersonInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(method = RequestMethod.GET, value = "/{personName}")
    public ResponseEntity<?> actionFullPersonName(@PathVariable String personName) {
        return ResponseEntity.ok(String.format("Hi, %s", personName));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> actionFullPersonName() {
        return ResponseEntity.ok(this.personInfoService.getPersonName());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/person-states")
    public ResponseEntity<?> actionPersonStates() {
        return ResponseEntity.ok(this.personInfoService.getPersonStateCode());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/current-person-state")
    public ResponseEntity<?> actionCurrentPersonState() {
        return ResponseEntity.ok(this.personInfoService.isCurrentPersonActiv());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/is-state-count-valid")
    public ResponseEntity<?> isStateCountValid() {
        return ResponseEntity.ok(this.personInfoService.isStateCountValid());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/current-date")
    public ResponseEntity<?> actionCurrentDate() {
        return ResponseEntity.ok(new Date());
    }
}
