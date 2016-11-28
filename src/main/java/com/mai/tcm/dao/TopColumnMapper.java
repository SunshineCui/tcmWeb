package com.mai.tcm.dao;

import com.mai.framework.base.BaseDao;
import com.mai.framework.feature.mybatis.Page;
import com.mai.tcm.model.TopColumn;
import com.mai.tcm.model.TopColumnExample;
import java.util.List;

import com.mai.tcm.vo.web.TopColumnListDto;
import com.mai.tcm.vo.web.TopColumnListVo;
import org.apache.ibatis.annotations.Param;

public interface TopColumnMapper extends BaseDao<TopColumn, String> {
    int countByExample(TopColumnExample example);

    int deleteByExample(TopColumnExample example);

    int deleteByPrimaryKey(String top_columnID);

    int insert(TopColumn record);

    int insertSelective(TopColumn record);

    List<TopColumn> selectByExample(TopColumnExample example);

    TopColumn selectByPrimaryKey(String top_columnID);

    int updateByExampleSelective(@Param("record") TopColumn record, @Param("example") TopColumnExample example);

    int updateByExample(@Param("record") TopColumn record, @Param("example") TopColumnExample example);

    int updateByPrimaryKeySelective(TopColumn record);

    int updateByPrimaryKey(TopColumn record);


    /*下面为自定义*/
    List<TopColumnListVo> selectByTopColumnListVoAndPage(Page<TopColumnListVo> page, TopColumnListVo topColumnListVo);

    List<TopColumnListDto> selectByTopColumnListDtoAndPage(Page<TopColumnListDto> page, TopColumnListDto topColumnListDto);

}