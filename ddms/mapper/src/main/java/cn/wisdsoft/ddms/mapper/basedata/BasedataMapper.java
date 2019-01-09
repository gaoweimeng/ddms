package cn.wisdsoft.ddms.mapper.basedata;

import cn.wisdsoft.ddms.pojo.Basedata;
import cn.wisdsoft.ddms.pojo.BasedataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BasedataMapper {
    int countByExample(BasedataExample example);

    int deleteByExample(BasedataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Basedata record);

    int insertSelective(Basedata record);

    List<Basedata> selectByExample(BasedataExample example);

    Basedata selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Basedata record, @Param("example") BasedataExample example);

    int updateByExample(@Param("record") Basedata record, @Param("example") BasedataExample example);

    int updateByPrimaryKeySelective(Basedata record);

    int updateByPrimaryKey(Basedata record);

    List<Basedata> selectAllBaseData(String type);
}