package com.imooc.security.browser;

import com.imooc.security.browser.support.SimpleRespone;
import com.imooc.security.core.properties.SecurityProperties;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wbcaoa on 2018/5/18.
 * 自定义跳转
 */
@RestController
public class BrowserSecurityController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired private SecurityProperties securityProperties;

    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleRespone requrieAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //根据请求的url后缀 判断跳转路径
        SavedRequest saveRequest = requestCache.getRequest(request,response);
        if (saveRequest != null){
            String targetUrl = saveRequest.getRedirectUrl();
            logger.info("引发跳转的请求是: " + targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl,".html")){//html后缀跳转
                redirectStrategy.sendRedirect(request,response,securityProperties.getBrowser().getLoginPage());
            }
        }
        return new SimpleRespone("您所访问的路径需要身份认证，请引导用户登录!");
    }
}
