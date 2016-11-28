package com.mai.tcm.service;


import com.mai.framework.base.BaseException;
import com.mai.framework.base.BaseService;
import com.mai.framework.feature.mybatis.Page;
import com.mai.tcm.model.TopColumn;
import com.mai.tcm.vo.web.TopColumnListDto;
import com.mai.tcm.vo.web.TopColumnListVo;

import java.util.List;

/**
 * 用户 业务 接口
 *
 **/
public interface TopColumnService extends BaseService<TopColumn, String> {

    public TopColumn getTopColumnByID(String TopColumnID) throws BaseException;

    public int addTopColumn(TopColumn TopColumn) throws BaseException;

    public int updateTopColumn(TopColumn TopColumn) throws BaseException;

    public List<TopColumnListVo> selectByTopColumnListVoAndPage(Page<TopColumnListVo> page, TopColumnListVo TopColumnListVo);

    public List<TopColumnListDto> selectByTopColumnListDtoAndPage(Page<TopColumnListDto> page, TopColumnListDto TopColumnListDto);
}
