package cn.qhjys.crm.service;

import cn.qhjys.crm.enmus.ResultEnum;
import cn.qhjys.crm.entity.User;
import cn.qhjys.crm.exception.MyException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author oyr
 * @Description: ${todo}
 * @date 2018/5/23 0023下午 2:09
 */
@Service
public class UserService {

    private static Map map = new HashMap();

    static {
        map.put(new Long(1), new User(new Long(1), "name1", "男", 10));
        map.put(new Long(1), new User(new Long(2), "name2", "男", 20));
        map.put(new Long(1), new User(new Long(3), "name3", "男", 30));

    }

    public void hello() throws MyException {
        //测试全局异常处理类是否有用
        throw new MyException(ResultEnum.SERVER_ERROR);
    }


    public User findById(Long id) {
        return (User) map.get(id);
    }

    public void delete(Long id) {
        map.remove(id);
    }
}
