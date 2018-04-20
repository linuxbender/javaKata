package ch.theforce.springRedis;

import lombok.extern.java.Log;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;

@Log
@SpringBootApplication
public class SpringRedisApplication {

    private ApplicationRunner titleRunner(String title, ApplicationRunner rr) {
        return args -> {
            log.info(title.toUpperCase() + ":");
            rr.run(args);
        };
    }

    @Bean
    ApplicationRunner geography(RedisTemplate<String, String> rt) {
        return titleRunner("geography", args -> {
            GeoOperations<String, String> geo = rt.opsForGeo();
            geo.add("Sicily", new Point(13.361389, 38.1155556),"Arigento");
            geo.add("Sicily", new Point(15.087269, 37.502669),"Catania");
            geo.add("Sicily", new Point(13.583333, 37.3155556),"Palermo");

            Circle circle = new Circle(new Point(13.583333, 37.316667),new Distance(100, RedisGeoCommands.DistanceUnit.KILOMETERS));
            GeoResults<RedisGeoCommands.GeoLocation<String>> geoResult = geo.radius("Sicily", circle);
            geoResult.getContent().forEach(c -> log.info(c.toString()));
        });
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisApplication.class, args);
    }
}
