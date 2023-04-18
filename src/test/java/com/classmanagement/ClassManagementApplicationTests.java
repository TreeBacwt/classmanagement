package com.classmanagement;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@SpringBootTest
class ClassManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
//		Logger logger = LoggerFactory.getLogger("what");
//		logger.info("111");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("语文", 11);
        map.put("数学", 23);
        Gson gson = new Gson();
        System.out.println(gson.toJson(map));
        System.out.println("语文");
    }

}
