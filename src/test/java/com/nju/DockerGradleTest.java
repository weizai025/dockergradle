package com.nju;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author maw-b
 * @date 2021/8/16 13:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DockerGradleTest {
    @Test
    public void contextLoadTest() {
        System.out.println("springboot test");
    }
}
