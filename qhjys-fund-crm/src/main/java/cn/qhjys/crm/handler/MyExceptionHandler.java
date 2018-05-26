package cn.qhjys.crm.handler;

import cn.qhjys.crm.VO.ResultVO;
import cn.qhjys.crm.enmus.ResultEnum;
import cn.qhjys.crm.exception.MyException;
import cn.qhjys.crm.utils.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;


/**
 * @author oyr
 * @Description: 这是一个全局异常处理类
 * @date 2018/5/23 0023下午 1:56
 */
@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {


    /**
     * 404处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResultVO noHandlerFoundException(NoHandlerFoundException e) {
        return ResultVoUtil.error(ResultEnum.URL_NOT_FIND.getCode(), ResultEnum.URL_NOT_FIND.getMessage());
    }

    /**
     * 参数错误处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO unknownException(ConstraintViolationException e) {
        //处理方法参数错误抛出的异常
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        ConstraintViolation<?> v = null;
        for (ConstraintViolation<?> violation : constraintViolations) {
            //收集第一个异常信息就好了
            v = violation;
            break;
        }
        return ResultVoUtil.error(ResultEnum.PARAM_ERROR.getCode(), v.getMessage());
    }


    /**
     * 指定处理MyException的异常
     * @param e
     * @return
     * */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ResultVO handle1(MyException e){
        e.printStackTrace();
        return ResultVoUtil.error(e.getCode(), e.getMessage());
    }


    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO unknownException(Exception e) {
        //未知异常
        log.error("600 error:{}", e.getMessage());
        return ResultVoUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMessage());
    }

}
