package com.cowboy.exception;

import lombok.Data;

/**
 * 自定义异常信息
 *
 * @author huxu
 * @create 2017-12-09 13:49
 **/
@Data
public class UserNotExistException extends RuntimeException{

    private static final long serialVersionUID = 5483082169331458689L;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    private String id;


}
