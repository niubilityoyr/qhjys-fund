package cn.qhjys.crm.controller;

import cn.qhjys.crm.QO.UserQO;
import cn.qhjys.crm.VO.ResultVO;
import cn.qhjys.crm.enmus.ResultEnum;
import cn.qhjys.crm.entity.User;
import cn.qhjys.crm.exception.MyException;
import cn.qhjys.crm.service.UserService;
import cn.qhjys.crm.utils.ResultVoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author oyr
 * @Description: ${todo}
 * @date 2018/5/24 0024下午 6:03
 */
@Slf4j
@Api("用户管理")
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private UserService service;


    @ApiOperation(httpMethod = "POST", value = "新增用户")
    @RequestMapping(method = RequestMethod.POST)
    public ResultVO save(@Valid UserQO user, BindingResult result){
        //先判断参数是否有误
        if(result.hasErrors()){
            throw new MyException(ResultEnum.PARAM_ERROR.getCode(),
                    result.getFieldError().getDefaultMessage());
        }
        //数据库保存数据
        //service.save(user);
        //返回成功
        return ResultVoUtil.success();
    }

    @ApiOperation(httpMethod = "DELETE", value = "删除用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultVO delete(@Valid @PathVariable @NotNull(message = "id不能为空") Long id,
                           BindingResult result){
        //先判断参数是否有误
        if(result.hasErrors()){
            throw new MyException(ResultEnum.PARAM_ERROR.getCode(),
                    result.getFieldError().getDefaultMessage());
        }
        service.delete(id);
        return ResultVoUtil.success();
    }


    @ApiOperation(httpMethod = "GET", value = "根据id查询用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultVO findById(@Valid @PathVariable @NotNull(message = "id不能为空") Long id,
                             BindingResult result){
        //先判断参数是否有误
        if(result.hasErrors()){
            throw new MyException(ResultEnum.PARAM_ERROR.getCode(),
                    result.getFieldError().getDefaultMessage());
        }
        User user = service.findById(id);
        return ResultVoUtil.success(user);
    }

}
