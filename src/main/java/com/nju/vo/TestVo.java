package com.nju.vo;


import java.time.LocalDateTime;

/**
 * @author maw-b
 * @date 2021/8/4 17:24
 */
public class TestVo {

    private Integer id;

    private String name;

    private LocalDateTime localDateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
