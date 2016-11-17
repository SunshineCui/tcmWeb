package com.mai.tcm.dao;

import com.mai.framework.base.BaseDao;
import com.mai.framework.feature.mybatis.Page;
import com.mai.tcm.model.Carousel;
import com.mai.tcm.model.CarouselExample;
import java.util.List;

import com.mai.tcm.vo.web.CarouselListDto;
import com.mai.tcm.vo.web.CarouselListVo;
import org.apache.ibatis.annotations.Param;

public interface CarouselMapper extends BaseDao<Carousel, String> {
    int countByExample(CarouselExample example);

    int deleteByExample(CarouselExample example);

    int deleteByPrimaryKey(String carouselID);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    List<Carousel> selectByExample(CarouselExample example);

    Carousel selectByPrimaryKey(String carouselID);

    int updateByExampleSelective(@Param("record") Carousel record, @Param("example") CarouselExample example);

    int updateByExample(@Param("record") Carousel record, @Param("example") CarouselExample example);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);

    /*下面为自定义*/
    List<CarouselListVo> selectByCarouselListVoAndPage(Page<CarouselListVo> page, CarouselListVo carouselListVo);

    List<CarouselListDto> selectByCourseListDtoAndPage(Page<CarouselListDto> page, CarouselListDto carouselListDto);
}