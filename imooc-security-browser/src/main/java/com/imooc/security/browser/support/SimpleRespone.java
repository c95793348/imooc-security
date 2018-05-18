package com.imooc.security.browser.support;

/**
 * Created by wbcaoa on 2018/5/18.
 */
public class SimpleRespone {

    private Object content;

    public SimpleRespone(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
