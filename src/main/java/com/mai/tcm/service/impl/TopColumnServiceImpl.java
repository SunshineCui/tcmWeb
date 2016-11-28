package com.mai.tcm.service.impl;

import com.mai.framework.base.BaseDao;
import com.mai.framework.base.BaseException;
import com.mai.framework.base.BaseServiceImpl;
import com.mai.framework.feature.mybatis.Page;
import com.mai.tcm.dao.TopColumnMapper;
import com.mai.tcm.model.TopColumn;
import com.mai.tcm.service.TopColumnService;
import com.mai.tcm.vo.web.TopColumnListDto;
import com.mai.tcm.vo.web.TopColumnListVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/24.
 */
@Service
public class TopColumnServiceImpl extends BaseServiceImpl<TopColumn, String> implements TopColumnService {

    @Resource
    private TopColumnMapper topColumnMapper;

    @Override
    public BaseDao<TopColumn, String> getDao() {
        return topColumnMapper;
    }

    @Override
    public TopColumn getTopColumnByID(String topColumnID) throws BaseException {
        return selectById(topColumnID);
    }

    @Override
    public int addTopColumn(TopColumn topColumn) throws BaseException {
        return insert(topColumn);
    }

    @Override
    public int updateTopColumn(TopColumn topColumn) throws BaseException {
        return update(topColumn);
    }

    @Override
    public List<TopColumnListVo> selectByTopColumnListVoAndPage(Page<TopColumnListVo> page, TopColumnListVo topColumnListVo) {
        return topColumnMapper.selectByTopColumnListVoAndPage(page,topColumnListVo);
    }

    @Override
    public List<TopColumnListDto> selectByTopColumnListDtoAndPage(Page<TopColumnListDto> page, TopColumnListDto topColumnListDto) {
        return topColumnMapper.selectByTopColumnListDtoAndPage(page, topColumnListDto);
    }
}
