package cn.qhjys.crm.controller;

import cn.qhjys.crm.QO.UserQO;
import cn.qhjys.crm.VO.ResultVO;
import cn.qhjys.crm.enmus.ResultEnum;
import cn.qhjys.crm.entity.CrmUser;
import cn.qhjys.crm.exception.MyException;
import cn.qhjys.crm.group.GroupA;
import cn.qhjys.crm.service.UserService;
import cn.qhjys.crm.utils.ResultVoUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author oyr
 * @Description: ${todo}
 * @date 2018/5/24 0024下午 6:03
 */
@Slf4j
@Api(tags = "用户管理")
@RequestMapping("/user")
@RestController
@Validated
public class UserController {

    @Resource
    private UserService service;


    @ApiOperation(httpMethod = "POST", value = "新增用户")
    @RequestMapping(method = RequestMethod.POST)
    public ResultVO save(@Valid @RequestBody UserQO user, BindingResult result){
        //先判断参数是否有误
        if(result.hasErrors()){
            throw new MyException(ResultEnum.PARAM_ERROR.getCode(),
                    result.getFieldError().getDefaultMessage());
        }
        //数据库保存数据
        service.save(user);
        //返回成功
        return ResultVoUtil.success();
    }


    @ApiOperation(httpMethod = "DELETE", value = "删除用户")
    @ApiImplicitParam(name="id", value = "用户ID", required = true, dataType = "Long", paramType = "query")
    @RequestMapping(method = RequestMethod.DELETE)
    public ResultVO delete(@Min(value = 0, message = "用户id是大于0的") @NotNull(message="用户ID不能为空") Long id){
        service.delete(id);
        return ResultVoUtil.success();
    }


    @ApiOperation(httpMethod = "GET", value = "根据id查询用户信息")
    @ApiImplicitParam(name="id", value = "用户ID", required = true, dataType = "Long", paramType = "query")
    @RequestMapping(method = RequestMethod.GET)
    public ResultVO findById(@NotNull(message="用户ID不能为空") Long id){
        CrmUser user = service.findById(id);
        return ResultVoUtil.success(user);
    }

    @ApiOperation(httpMethod = "PUT", value = "修改用户信息")
    @RequestMapping(method = RequestMethod.PUT)
    public ResultVO update(@Validated({GroupA.class}) UserQO user, BindingResult result){
        //先判断参数是否有误
        if(result.hasErrors()){
            throw new MyException(ResultEnum.PARAM_ERROR.getCode(),
                    result.getFieldError().getDefaultMessage());
        }
        service.update(user);
        return ResultVoUtil.success();
    }

    @ApiOperation(httpMethod = "GET", value = "分页查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page", value = "显示第几页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name="pageSize", value = "一页显示多少数据", required = false, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResultVO findPage(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
                             @RequestParam(value = "pageSize", defaultValue = "20", required = false) int pageSize){
        PageInfo<CrmUser> info = service.findPage(page, pageSize);
        return ResultVoUtil.success(info);
    }
}
