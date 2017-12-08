package com.cowboy.web.controller;


import com.cowboy.dto.User;
import com.cowboy.dto.UserQueryCondition;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户控制类
 *
 * @author huxu
 * @create 2017-12-08 9:49
 **/

@RestController
@RequestMapping("/user")
@Api(value = "测试接口", description = "MVC接口")
public class UserController {

    /*@Autowired
    private ProviderSignInUtils providerSignInUtils;*/

    @PostMapping("/regist")
    public void regist(User user, HttpServletRequest request) {

        //不管是注册用户还是绑定用户，都会拿到一个用户唯一标识。
        String userId = user.getUsername();
        //providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
    }

    @GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user) {
        return user;
    }

    @PostMapping
    @ApiOperation(value = "创建用户")
    public User create(@Valid @RequestBody User user) {     //@RequestBody映射请求体到java方法的参数，
        setUser(user);
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {    //@Valid和 BindingResult验证请求参数的合法性并处理校验结果

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError)error;
                String message = fieldError.getField() + error.getDefaultMessage();
                System.out.println(message);
            });
        }

        setUser(user);
        return user;
    }

    /**
     * 重构相同部分，  选中ctr + alt + m
     * @param user
     */
    private void setUser(@Valid @RequestBody User user) {
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "用户查询服务")
    public List<User> query(UserQueryCondition condition, @PageableDefault(page = 2, size = 17, sort = "username,asc") Pageable pageable) {

        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")   //正则表达式只能是数字
    @JsonView(User.UserDetailView.class)        //这个注解的作用就是控制输入输出后的json，视图类型控制
    @ApiOperation(value = "根据ID获取用户信息")
    public User getInfo(@ApiParam("用户id") @PathVariable String id) {    //@PathVariable(required = false)
//		throw new RuntimeException("user not exist");
        System.out.println("进入getInfo服务");
        User user = new User();
        user.setUsername("tom");
        return user;
    }

}