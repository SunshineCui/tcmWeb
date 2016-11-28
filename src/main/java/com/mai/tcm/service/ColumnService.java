package com.mai.tcm.service;


import com.mai.framework.base.BaseException;
import com.mai.framework.base.BaseService;
import com.mai.framework.feature.mybatis.Page;
import com.mai.tcm.model.Column;
import com.mai.tcm.vo.web.ColumnListDto;
import com.mai.tcm.vo.web.ColumnListVo;

import java.util.List;

/**
 * 用户 业务 接口
 *
 **/
public interface ColumnService extends BaseService<Column, String> {

    public Column getColumnByID(String ColumnID) throws BaseException;

    public int addColumn(Column Column) throws BaseException;

    public int updateColumn(Column Column) throws BaseException;

    public List<ColumnListVo> selectByColumnListVoAndPage(Page<ColumnListVo> page, ColumnListVo ColumnListVo);

    public List<ColumnListDto> selectByColumnListDtoAndPage(Page<ColumnListDto> page, ColumnListDto columnListDto);
}
