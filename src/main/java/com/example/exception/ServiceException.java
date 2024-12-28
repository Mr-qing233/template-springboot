package com.example.exception;

import com.example.vo.ResultEnum;
import lombok.Getter;


/**
 * 自定义异常
 */
@Getter
public class ServiceException extends RuntimeException{
    /**
     * 错误代码
     */
    private String code;
    /**
     * 错误信息
     */
    private String msg;
    /**
     * 自定义异常构造
     */
    public ServiceException(ResultEnum resultEnum){
        super(resultEnum.getResultMsg());
        this.code = resultEnum.getResultCode();
        this.msg = resultEnum.getResultMsg();
    }
}
