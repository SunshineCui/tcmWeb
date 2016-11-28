package com.mai.tcm.dao;

import com.mai.framework.base.BaseDao;
import com.mai.framework.feature.mybatis.Page;
import com.mai.tcm.model.Column;
import com.mai.tcm.model.ColumnExample;
import java.util.List;

import com.mai.tcm.vo.web.ColumnListDto;
import com.mai.tcm.vo.web.ColumnListVo;
import org.apache.ibatis.annotations.Param;

public interface ColumnMapper extends BaseDao<Column, String> {
    int countByExample(ColumnExample example);

    int deleteByExample(ColumnExample example);

    int deleteByPrimaryKey(String columnID);

    int insert(Column record);

    int insertSelective(Column record);

    List<Column> selectByExample(ColumnExample example);

    Column selectByPrimaryKey(String columnID);

    int updateByExampleSelective(@Param("record") Column record, @Param("example") ColumnExample example);

    int updateByExample(@Param("record") Column record, @Param("example") ColumnExample example);

    int updateByPrimaryKeySelective(Column record);

    int updateByPrimaryKey(Column record);

    /*下面为自定义*/
    List<ColumnListVo> selectByColumnListVoAndPage(Page<ColumnListVo> page, ColumnListVo columnListVo);

    List<ColumnListDto> selectByColumnListDtoAndPage(Page<ColumnListDto> page, ColumnListDto columnListDto);

}