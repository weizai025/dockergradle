package com.nju.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * @author maw-b
 * @date 2021/8/16 14:04
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class HelloServiceTest {

    @InjectMocks
    @Spy
    private HelloService helloService;

    @Test
    public void add() {
        int a=1;
        int b=2;
        int add = helloService.add(a, b);
        assertEquals(add,3);
    }
}