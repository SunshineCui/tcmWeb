package com.mai.tcm.service;

import com.mai.framework.base.BaseException;
import com.mai.framework.base.BaseService;
import com.mai.framework.feature.mybatis.Page;
import com.mai.tcm.model.Carousel;
import com.mai.tcm.vo.web.CarouselListDto;
import com.mai.tcm.vo.web.CarouselListVo;

import java.util.List;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/8.
 */
public interface CarouselService {

    public List<CarouselListVo> selectByCarouselListVoAndPage(Page<CarouselListVo> page, CarouselListVo carouselListVo) throws BaseException;

    public Carousel getCarouselByID(String carouselID) throws BaseException;

    public int addCarousel(Carousel carousel) throws BaseException;

    public int updateCarousel(Carousel carousel) throws BaseException;

    public List<CarouselListDto> selectByCourseListDtoAndPage(Page<CarouselListDto> page, CarouselListDto carouselListDto);
}
