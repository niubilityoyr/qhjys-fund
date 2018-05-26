package cn.qhjys.crm.mapper;

import cn.qhjys.crm.entity.CrmUser;
import cn.qhjys.crm.entity.CrmUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CrmUserMapper {
    int countByExample(CrmUserExample example);

    int deleteByExample(CrmUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CrmUser record);

    int insertSelective(CrmUser record);

    List<CrmUser> selectByExample(CrmUserExample example);

    CrmUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CrmUser record, @Param("example") CrmUserExample example);

    int updateByExample(@Param("record") CrmUser record, @Param("example") CrmUserExample example);

    int updateByPrimaryKeySelective(CrmUser record);

    int updateByPrimaryKey(CrmUser record);
}