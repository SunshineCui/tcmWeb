package com.mai.tcm.service.impl;

import com.mai.framework.base.BaseDao;
import com.mai.framework.base.BaseException;
import com.mai.framework.base.BaseServiceImpl;
import com.mai.framework.feature.mybatis.Page;
import com.mai.tcm.dao.ColumnMapper;
import com.mai.tcm.dao.TopColumnMapper;
import com.mai.tcm.model.Column;
import com.mai.tcm.model.TopColumn;
import com.mai.tcm.service.ColumnService;
import com.mai.tcm.service.TopColumnService;
import com.mai.tcm.vo.web.ColumnListDto;
import com.mai.tcm.vo.web.ColumnListVo;
import com.mai.tcm.vo.web.TopColumnListVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/24.
 */
@Service
public class ColumnServiceImpl extends BaseServiceImpl<Column, String> implements ColumnService {

    @Resource
    private ColumnMapper columnMapper;

    @Override
    public BaseDao<Column, String> getDao() {
        return columnMapper;
    }

    @Override
    public Column getColumnByID(String columnID) throws BaseException {
        return selectById(columnID);
    }

    @Override
    public int addColumn(Column column) throws BaseException {
        return insert(column);
    }

    @Override
    public int updateColumn(Column column) throws BaseException {
        return update(column);
    }

    @Override
    public List<ColumnListVo> selectByColumnListVoAndPage(Page<ColumnListVo> page, ColumnListVo columnListVo) {
        return columnMapper.selectByColumnListVoAndPage(page,columnListVo);
    }

    @Override
    public List<ColumnListDto> selectByColumnListDtoAndPage(Page<ColumnListDto> page, ColumnListDto columnListDto) {
        return columnMapper.selectByColumnListDtoAndPage(page, columnListDto);
    }

}
