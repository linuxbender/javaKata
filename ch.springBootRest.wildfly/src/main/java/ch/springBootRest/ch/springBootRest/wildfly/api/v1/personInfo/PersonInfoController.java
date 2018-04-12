package ch.springBootRest.ch.springBootRest.wildfly.api.v1.personInfo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personinfo")
public class PersonInfoController {

    private final IPersonInfoService personInfoService;

    public PersonInfoController(IPersonInfoService personInfoService) {
        this.personInfoService = personInfoService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{personName}")
    public String actionFullPersonName(@PathVariable String personName) {
        return String.format("Hi, %s", personName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String actionFullPersonName() {
        return this.personInfoService.getPersonName();
    }


}
