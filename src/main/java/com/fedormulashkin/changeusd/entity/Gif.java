package com.fedormulashkin.changeusd.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;


public class Gif {
    private Object data;

    public Gif() {
    }

    public Gif(Object object) {
        this.data = object;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object object) {
        this.data = object;
    }

}
