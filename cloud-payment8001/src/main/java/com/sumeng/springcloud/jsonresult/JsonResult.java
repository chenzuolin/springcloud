package com.sumeng.springcloud.jsonresult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenzuolin
 * @Description
 * @date 2020/4/19 15:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public JsonResult(Integer code,String message){
        this(code,message,null);
    }
}
