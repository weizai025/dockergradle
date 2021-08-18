package com.nju.controller;

import com.nju.vo.TestVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author maw-b
 * @date 2021/8/4 17:19
 */
@RestController
public class HelloController {

    @GetMapping("/test")
    public TestVo test() {
        TestVo vo = new TestVo();
        vo.setName("test");
        vo.setId(new Random().nextInt());
        vo.setLocalDateTime(LocalDateTime.now());
        return vo;
    }
}
