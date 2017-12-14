package com.cowboy.dto;

import lombok.Data;

/**
 * 上传实体
 *
 * @author huxu
 * @create 2017-12-08 9:57
 **/
@Data
public class FileInfo {

    private String path;

    public FileInfo(String path){
        this.path = path;
    }

}
