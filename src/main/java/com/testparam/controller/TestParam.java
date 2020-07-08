package com.testparam.controller;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class TestParam {
    @ApiModelProperty(value = "自增id")
    private int id;

    private List<ParamC> paramCList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ParamC> getParamCList() {
        return paramCList;
    }

    public void setParamCList(List<ParamC> paramCList) {
        this.paramCList = paramCList;
    }
}
