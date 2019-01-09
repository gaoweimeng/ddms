package cn.wisdsoft.ddms.service.baseDataService;
import cn.wisdsoft.ddms.pojo.Basedata;
import cn.wisdsoft.pojo.DdmsResult;

import java.util.List;

/**
* @Description:  TODO
* @Author:  宋军伟
* @CreateDate:  2018/11/3 17:25
* @Version:  1.0
*/
public interface BaseDataService {
    /**
     * 查询所有学科门类
     * @param type
     * @return
     */
    List<Basedata> selectBaseData(String type);
}
