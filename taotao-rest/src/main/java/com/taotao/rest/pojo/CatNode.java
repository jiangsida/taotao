package com.taotao.rest.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author jiang
 * @create 2018-01-05 9:35
 * @desc
 **/

public class CatNode {

    @JsonProperty("n")
    private  String name;
    @JsonProperty("u")
    private  String url;
    @JsonProperty("i")
    private List<?> item;

    public void setName (String name) {
        this.name = name;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public void setItem (List<?> item) {
        this.item = item;
    }

    public String getName () {
        return name;
    }

    public String getUrl () {
        return url;
    }

    public List<?> getItem () {
        return item;
    }
}
