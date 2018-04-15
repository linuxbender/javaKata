package ch.springBootRest.wildfly.api.v1.person;

import ch.springBootRest.wildfly.api.v1.person.dto.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @PostMapping
    public ResponseEntity<?> actionAddPerson(@Validated @RequestBody PersonDto personDto) {

        PersonDto person = new PersonDto.PersonBuilder(personDto.getId(), personDto.getFirstName(), personDto.getLastName()).build();
        return ResponseEntity.ok(person);
    }
}
