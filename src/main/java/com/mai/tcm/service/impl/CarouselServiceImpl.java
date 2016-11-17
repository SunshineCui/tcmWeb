package com.mai.tcm.service.impl;

import com.mai.framework.base.BaseDao;
import com.mai.framework.base.BaseException;
import com.mai.framework.base.BaseServiceImpl;
import com.mai.framework.feature.mybatis.Page;
import com.mai.tcm.dao.CarouselMapper;
import com.mai.tcm.model.Carousel;
import com.mai.tcm.service.CarouselService;
import com.mai.tcm.vo.web.CarouselListDto;
import com.mai.tcm.vo.web.CarouselListVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/8.
 */
@Service
public class CarouselServiceImpl extends BaseServiceImpl<Carousel, String> implements CarouselService {

    @Resource
    private CarouselMapper carouselMapper;

    @Override
    public BaseDao<Carousel, String> getDao() {
        return carouselMapper;
    }

    @Override
    public List<CarouselListVo> selectByCarouselListVoAndPage(Page<CarouselListVo> page, CarouselListVo carouselListVo) throws BaseException {
        return carouselMapper.selectByCarouselListVoAndPage(page, carouselListVo);
    }

    @Override
    public Carousel getCarouselByID(String carouselID) throws BaseException {
        return selectById(carouselID);
    }

    @Override
    public int addCarousel(Carousel carousel) throws BaseException {
        return insert(carousel);
    }

    @Override
    public int updateCarousel(Carousel carousel) throws BaseException {
        return update(carousel);
    }

    @Override
    public List<CarouselListDto> selectByCourseListDtoAndPage(Page<CarouselListDto> page, CarouselListDto carouselListDto) {
        return carouselMapper.selectByCourseListDtoAndPage(page, carouselListDto);
    }
}
