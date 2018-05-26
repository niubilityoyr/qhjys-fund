package cn.qhjys.crm.service;

import cn.qhjys.crm.QO.UserQO;
import cn.qhjys.crm.enmus.ResultEnum;
import cn.qhjys.crm.entity.CrmUser;
import cn.qhjys.crm.entity.CrmUserExample;
import cn.qhjys.crm.exception.MyException;
import cn.qhjys.crm.mapper.CrmUserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        //只有我输入过的字段才会改变
        mapper.updateByPrimaryKeySelective(crmUser);
    }

    public PageInfo<CrmUser> findPage(int page, int pageSize) {
        //设置分页
        PageHelper.startPage(page, pageSize);
        //开始查询
        CrmUserExample example = new CrmUserExample();
        List<CrmUser> list = mapper.selectByExample(example);
        //将数据封装到pageinfo中，PageInfo对象中有封装了分页的数据
        PageInfo<CrmUser> info = new PageInfo<>(list);
        return info;
    }
}
