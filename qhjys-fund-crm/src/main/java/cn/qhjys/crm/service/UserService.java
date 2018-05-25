package cn.qhjys.crm.service;

import cn.qhjys.crm.QO.UserQO;
import cn.qhjys.crm.dao.CrmUserMapper;
import cn.qhjys.crm.enmus.ResultEnum;
import cn.qhjys.crm.entity.CrmUser;
import cn.qhjys.crm.entity.User;
import cn.qhjys.crm.exception.MyException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author oyr
 * @Description: ${todo}
 * @date 2018/5/23 0023下午 2:09
 */
@Service
public class UserService {

    @Resource
    private CrmUserMapper mapper;

    public void hello() throws MyException {
        //测试全局异常处理类是否有用
        throw new MyException(ResultEnum.SERVER_ERROR);
    }

    public CrmUser findById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void delete(Long id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void save(UserQO user) {
        CrmUser crmUser = new CrmUser();
        BeanUtils.copyProperties(user, crmUser);
        mapper.insert(crmUser);
    }

    public void update(UserQO user) {
        CrmUser crmUser = new CrmUser();
        BeanUtils.copyProperties(user, crmUser);
        mapper.updateByPrimaryKey(crmUser);
    }

    public PageInfo<CrmUser> findPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<CrmUser> list = mapper.selectAll();
        PageInfo<CrmUser> info = new PageInfo<>(list);
        return info;
    }
}
