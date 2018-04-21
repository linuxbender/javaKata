package ch.theforce.springRedis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.time.Instant;
import java.util.*;

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
            geo.add("Sicily", new Point(13.361389, 38.1155556), "Arigento");
            geo.add("Sicily", new Point(15.087269, 37.502669), "Catania");
            geo.add("Sicily", new Point(13.583333, 37.3155556), "Palermo");

            Circle circle = new Circle(new Point(13.583333, 37.316667), new Distance(100, RedisGeoCommands.DistanceUnit.KILOMETERS));
            GeoResults<RedisGeoCommands.GeoLocation<String>> geoResult = geo.radius("Sicily", circle);
            geoResult.getContent().forEach(c -> log.info(c.toString()));
        });
    }

    @Bean
    ApplicationRunner repositories(LineItemRepository itemRepository, OrderRepository orderRepository) {
        return titleRunner("repositories", args -> {
            Long orderId = generateId();
            List<LineItem> lineItems = Arrays.asList(new LineItem(orderId, generateId(), "plunger"),
                    new LineItem(orderId, generateId(), "soup"),
                    new LineItem(orderId, generateId(), "Tee mug"));
            // save to redis
            lineItems.stream().map(itemRepository::save).forEach(item -> log.info(item.toString()));

            Order order = new Order(orderId, new Date(), lineItems);
            orderRepository.save(order);

            Collection<Order> results = orderRepository.findByWhen(order.getWhen());
            results.stream().forEach(it -> log.info("result:" + it.toString()));

        });
    }

    private Long generateId() {
        long newId = new Random().nextLong();
        return Math.max(newId, newId * -1);
    }

    public static final String TOBIC = "chat";

    @Bean
    ApplicationRunner pubSub(RedisTemplate<String, String> rt) {
        return titleRunner("publish/subscribe", args -> {
            rt.convertAndSend(TOBIC, "Hello World " + Instant.now().toString());
        });
    }

    @Bean
    RedisMessageListenerContainer messageListenerContainer(RedisConnectionFactory cf) {

        MessageListener ml = (message, pattern) -> {
            String msg = new String(message.getBody());
            log.info("message from: " + TOBIC + ": " + msg);
        };

        RedisMessageListenerContainer mlc = new RedisMessageListenerContainer();
        mlc.setConnectionFactory(cf);
        mlc.addMessageListener(ml, new PatternTopic(TOBIC));
        return mlc;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisApplication.class, args);
    }
}

interface OrderRepository extends CrudRepository<Order, Long> {
    Collection<Order> findByWhen(Date d);
}

interface LineItemRepository extends CrudRepository<LineItem, Long> {
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("orders")
class Order implements Serializable {

    @Id
    private Long Id;

    @Indexed
    private Date when;

    @Reference
    private List<LineItem> lineItems;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("lineItems")
class LineItem implements Serializable {

    @Indexed
    private Long OrderId;

    @Id
    private Long id;

    private String description;
}
