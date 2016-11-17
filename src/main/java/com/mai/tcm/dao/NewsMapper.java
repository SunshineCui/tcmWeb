package com.mai.tcm.dao;

import com.mai.framework.base.BaseDao;
import com.mai.framework.feature.mybatis.Page;
import com.mai.tcm.model.Carousel;
import com.mai.tcm.model.News;
import com.mai.tcm.model.NewsExample;
import java.util.List;

import com.mai.tcm.vo.web.CarouselListDto;
import com.mai.tcm.vo.web.CarouselListVo;
import com.mai.tcm.vo.web.NewsListDto;
import com.mai.tcm.vo.web.NewsListVo;
import org.apache.ibatis.annotations.Param;

public interface NewsMapper extends BaseDao<News, String> {
    int countByExample(NewsExample example);

    int deleteByExample(NewsExample example);

    int deleteByPrimaryKey(String newsID);

    int insert(News record);

    int insertSelective(News record);

    List<News> selectByExampleWithBLOBs(NewsExample example);

    List<News> selectByExample(NewsExample example);

    News selectByPrimaryKey(String newsID);

    int updateByExampleSelective(@Param("record") News record, @Param("example") NewsExample example);

    int updateByExampleWithBLOBs(@Param("record") News record, @Param("example") NewsExample example);

    int updateByExample(@Param("record") News record, @Param("example") NewsExample example);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);

    /*下面为自定义*/
    List<NewsListVo> selectByNewsListVoAndPage(Page<NewsListVo> page, NewsListVo newsListVo);

    List<NewsListDto> selectByNewsListDtoAndPage(Page<NewsListDto> page, NewsListDto newsListDto);
}