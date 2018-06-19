package com.lianxi.exception;

import com.lianxi.enums.ResultEnum;

public class BoyException extends RuntimeException {
    private Integer code;
    public  BoyException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
