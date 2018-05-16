package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import com.imooc.exception.UserNotExistException;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wbcaoa on 2018/5/14.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    @JsonView(User.UserSimpleView.class)
    public User create(@Valid @RequestBody User user, BindingResult errors){//参数校验（valid 与 BingdingResult同时使用）、时间戳根据不同业务 显示不同格式的日期时间

        if (errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");

        return user;
    }

    @PutMapping("/{id:\\d+}")
    @JsonView(User.UserSimpleView.class)
    public User update(@Valid @RequestBody User user, BindingResult errors){

        if (errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");

        return user;
    }


    @GetMapping
    @JsonView(User.UserSimpleView.class)
    //public List<User> query(@RequestParam(name = "username",required = false,defaultValue = "defaultname") String nickname) {
    public List<User> query(UserQueryCondition condition,
                            @PageableDefault(size = 8,page = 1,sort = "username,ageTo,asc") Pageable pageable) {

        //        logger.info("Parameters : " + condition.toString());
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(pageable.getSort());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());

        ArrayList<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());

        return users;
    }

    @GetMapping("/{id:\\d+}")//url正则校验参数
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(name = "id") String idxxxx){
        logger.info("getInfo方法参数id : " + idxxxx);

//        throw new UserNotExistException(idxxxx);
//        throw new RuntimeException("异常!!!");
        User user = new User();
        user.setUsername("coco");
        user.setPassword("110110");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable(name = "id") String idxxxxx){
        logger.info("delete方法参数id : " + idxxxxx);

        throw new UserNotExistException(idxxxxx);

    }

}
