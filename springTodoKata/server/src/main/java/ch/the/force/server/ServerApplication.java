package ch.the.force.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
public class ServerApplication {

	@GetMapping("events/{id}")
	Mono<Event> eventById(@PathVariable Long id) {
		return Mono.just(new Event(id, new Date()));
	}

	@GetMapping(value = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
	Flux<Event> events () {
		Flux<Event> eventFlux = Flux.fromStream(Stream.generate( () -> new Event(System.currentTimeMillis(), new Date())));

		return eventFlux;
	}

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
