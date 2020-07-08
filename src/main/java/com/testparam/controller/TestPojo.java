package com.testparam.controller;

import java.util.List;

public class TestPojo {
    private int i;
    private String name;

    private List<testPojo2> pojo2;

    public List<testPojo2> getPojo2() {
        return pojo2;
    }

    public void setPojo2(List<testPojo2> pojo2) {
        this.pojo2 = pojo2;
    }

    public TestPojo() {
    }


    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestPojo{" +
                "i=" + i +
                ", name='" + name + '\'' +
                ", pojo2=" + pojo2 +
                '}';
    }
}
