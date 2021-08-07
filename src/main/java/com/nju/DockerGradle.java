package com.nju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author maw-b
 * @date 2021/8/4 17:10
 */
@SpringBootApplication
public class DockerGradle {
    public static void main(String[] args) {
        SpringApplication.run(DockerGradle.class, args);
        System.out.println("程序启动");
    }

    /**
     * [start,end)
     * @param a
     * @param start
     * @param end
     */
    public static void reverse(int[] a, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            int temp = a[i + start];
            a[i + start] = a[end - i - 1];
            a[end - i - 1] = temp;
        }
    }
}
