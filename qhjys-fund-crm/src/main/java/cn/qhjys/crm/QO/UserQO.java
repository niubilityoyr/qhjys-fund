package cn.qhjys.crm.QO;

import cn.qhjys.crm.group.GroupA;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;


/**
 * @author oyr
 * @Description: ${todo}
 * @date 2018/5/23 0023下午 2:47
 */
@ApiModel(value = "crm用户")
@Data
public class UserQO {

    @NotNull(message = "用户id不能为空", groups = {GroupA.class})
    private Long id;

    @ApiModelProperty(required = true, value = "用户名", dataType = "String")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty(required = true, value = "描述", dataType = "String")
    @NotBlank(message = "描述不能为空")
    @Length(min = 5, max = 50, message = "请输入5-50个字符")
    private String remark;

}
