package cn.qhjys.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author oyr
 * @Description: ${todo}
 * @date 2018/5/24 0024下午 6:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String name;

    private String sex;

    private Integer age;

}
