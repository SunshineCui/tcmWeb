package com.mai.tcm.service.impl;

import com.mai.framework.base.BaseDao;
import com.mai.framework.base.BaseException;
import com.mai.framework.base.BaseServiceImpl;
import com.mai.framework.feature.mybatis.Page;
import com.mai.tcm.dao.NewsMapper;
import com.mai.tcm.model.News;
import com.mai.tcm.service.NewsService;
import com.mai.tcm.vo.web.NewsListDto;
import com.mai.tcm.vo.web.NewsListVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户Service实现类
 */
@Service
public class NewsServiceImpl extends BaseServiceImpl<News, String> implements NewsService {

    @Resource
    private NewsMapper newsMapper;

    @Override
    public BaseDao<News, String> getDao() {
        return newsMapper;
    }

    @Override
    public News getNewsByID(String newsID) throws BaseException {
        return selectById(newsID);
    }

    @Override
    public int addNews(News news) throws BaseException {
        return insert(news);
    }

    @Override
    public int updateNews(News news) throws BaseException {
        return update(news);
    }

    @Override
    public List<NewsListVo> selectByNewsListVoAndPage(Page<NewsListVo> page, NewsListVo newsListVo) {
        return newsMapper.selectByNewsListVoAndPage(page, newsListVo);
    }

    @Override
    public List<NewsListDto> selectByNewsListDtoAndPage(Page<NewsListDto> page, NewsListDto newsListDto) {
        return newsMapper.selectByNewsListDtoAndPage(page, newsListDto);
    }
}
