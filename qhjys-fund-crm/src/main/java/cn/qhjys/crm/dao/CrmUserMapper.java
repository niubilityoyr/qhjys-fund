package cn.qhjys.crm.dao;

import cn.qhjys.crm.entity.CrmUser;

import java.util.List;

public interface CrmUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CrmUser record);

    CrmUser selectByPrimaryKey(Long id);

    List<CrmUser> selectAll();

    int updateByPrimaryKey(CrmUser record);
}