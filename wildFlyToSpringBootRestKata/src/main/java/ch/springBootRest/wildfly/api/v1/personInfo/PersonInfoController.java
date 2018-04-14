package ch.springBootRest.wildfly.api.v1.personInfo;

import ch.springBootRest.wildfly.api.v1.personInfo.model.PersonStateEnum;
import ch.springBootRest.wildfly.api.v1.personInfo.service.PersonInfoService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    public String actionFullPersonName(@PathVariable String personName) {
        return String.format("Hi, %s", personName);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String actionFullPersonName() {
        return this.personInfoService.getPersonName();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/person-states")
    public ArrayList<PersonStateEnum> actionPersonStates() {
        return this.personInfoService.getPersonStateCode();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/current-person-state")
    public String actionCurrentPersonState() {
        return this.personInfoService.isCurrentPersonActiv();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/is-state-count-valid")
    public boolean isStateCountValid() {
        return this.personInfoService.isStateCountValid();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/current-date")
    public Date actionCurrentDate() {
        return new Date();
    }
}
