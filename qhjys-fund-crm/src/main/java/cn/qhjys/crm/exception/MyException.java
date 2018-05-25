package cn.qhjys.crm.exception;


import cn.qhjys.crm.enmus.ResultEnum;
import lombok.Getter;

/**
 * @author oyr
 * @Description: 自定义异常类
 * @date 2018/5/23 0023下午 1:50
 */
@Getter
public class MyException extends RuntimeException {//抛出RuntimeException异常才会回滚事务

    private Integer code;

    public MyException(Integer code, String message){
        super(message);
        this.code=code;
    }

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
