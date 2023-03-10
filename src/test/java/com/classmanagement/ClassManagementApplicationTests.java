package com.classmanagement;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@SpringBootTest
class ClassManagementApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test(){
		Logger logger = LoggerFactory.getLogger("what");
		logger.info("111");
	}

}
