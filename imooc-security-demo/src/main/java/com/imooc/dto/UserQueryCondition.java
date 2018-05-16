package com.imooc.dto;

/**
 * Created by wbcaoa on 2018/5/14.
 */
public class UserQueryCondition {

    private String username;

    private String age;

    private String ageTo;

    private String xxx;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(String ageTo) {
        this.ageTo = ageTo;
    }

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }

    @Override
    public String toString() {
        return "UserQueryCondition{" +
                "username='" + username + '\'' +
                ", age='" + age + '\'' +
                ", ageTo='" + ageTo + '\'' +
                ", xxx='" + xxx + '\'' +
                '}';
    }
}
