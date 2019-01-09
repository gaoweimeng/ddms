package cn.wisdsoft.ddms.service.baseDataService.Impl;

import cn.wisdsoft.ddms.mapper.basedata.BasedataMapper;
import cn.wisdsoft.ddms.pojo.Basedata;
import cn.wisdsoft.ddms.service.baseDataService.BaseDataService;
import cn.wisdsoft.pojo.DdmsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description:  TODO
* @Author:  宋军伟
* @CreateDate:  2018/11/3 21:15
* @Version:  1.0
*/
@Service
public class BaseDataServiceImpl implements BaseDataService {

    @Autowired
    private BasedataMapper basedataMapper;

    /**
     * 查询所有学科门类信息
     * @return subject 学科门类
     */
    @Override
    public List<Basedata> selectBaseData(String type) {
        List<Basedata> basedata = basedataMapper.selectAllBaseData(type);
        return basedata;
    }
}
