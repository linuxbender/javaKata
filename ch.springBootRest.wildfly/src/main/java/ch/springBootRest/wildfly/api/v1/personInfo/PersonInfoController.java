package ch.springBootRest.wildfly.api.v1.personInfo;

import ch.springBootRest.wildfly.api.v1.personInfo.model.PersonStateEnum;
import ch.springBootRest.wildfly.api.v1.personInfo.service.PersonInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/personinfo")
@CrossOrigin(origins = "*")
public class PersonInfoController {

    private final PersonInfoService personInfoService;

    public PersonInfoController(PersonInfoService personInfoService) {
        if (personInfoService == null) {
            throw new NullPointerException("personInfoService");
        }
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

    @RequestMapping(method = RequestMethod.GET,value = "/current-person-state")
    public String actionCurrentPersonState() {
        return this.personInfoService.isCurrentPersonActiv();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/is-state-count-valid")
    public boolean isStateCountValid(){
        return this.personInfoService.isStateCountValid();
    }
}
