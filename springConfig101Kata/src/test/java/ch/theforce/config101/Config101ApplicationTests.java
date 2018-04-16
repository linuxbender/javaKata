package ch.theforce.config101;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Config101ApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

	@Test
	public void contextLoads() {
        Assert.assertNotNull("The FooSearvice should not be null",this.applicationContext.getBean(FooService.class));
        Assert.assertNotNull("The BaaService should not be null",this.applicationContext.getBean(BaaService.class));
	}
}
