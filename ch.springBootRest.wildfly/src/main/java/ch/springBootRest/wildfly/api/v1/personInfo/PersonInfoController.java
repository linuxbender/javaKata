package ch.springBootRest.wildfly.api.v1.personInfo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personinfo")
@CrossOrigin(origins = "*")
public class PersonInfoController {

    private final IPersonInfoService personInfoService;

    public PersonInfoController(IPersonInfoService personInfoService) {
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

}
