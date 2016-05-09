package com.cmpe275;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cmpe275.TakeOutOrderingSystemApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TakeOutOrderingSystemApplication.class)
@WebAppConfiguration
public class TakeOutOrderingSystemApplicationTests {

	@Test
	public void contextLoads() {
	}

}
