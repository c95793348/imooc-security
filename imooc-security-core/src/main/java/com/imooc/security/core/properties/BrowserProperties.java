package com.imooc.security.core.properties;

/**
 * Created by wbcaoa on 2018/5/18.
 */
public class BrowserProperties {

    private String loginPage = "/imooc-signIn.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
