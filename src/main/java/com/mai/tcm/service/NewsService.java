package com.mai.tcm.service;


import com.mai.framework.base.BaseException;
import com.mai.framework.base.BaseService;
import com.mai.framework.feature.mybatis.Page;
import com.mai.tcm.model.News;
import com.mai.tcm.vo.web.NewsListDto;
import com.mai.tcm.vo.web.NewsListVo;

import java.util.List;

/**
 * 用户 业务 接口
 *
 **/
public interface NewsService extends BaseService<News, String> {

    public News getNewsByID(String NewsID) throws BaseException;

    public int addNews(News News) throws BaseException;

    public int updateNews(News News) throws BaseException;

    public List<NewsListVo> selectByNewsListVoAndPage(Page<NewsListVo> page, NewsListVo newsListVo);

    public List<NewsListDto> selectByNewsListDtoAndPage(Page<NewsListDto> page, NewsListDto newsListDto);
}
