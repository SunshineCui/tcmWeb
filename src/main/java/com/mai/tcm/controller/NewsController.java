package com.mai.tcm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mai.framework.base.BaseException;
import com.mai.framework.feature.mybatis.Page;
import com.mai.framework.util.JsonHelper;
import com.mai.framework.util.StringUtils;
import com.mai.framework.util.UUIDUtil;
import com.mai.tcm.model.BaseVo;
import com.mai.tcm.model.News;
import com.mai.tcm.security.MenuEnum;
import com.mai.tcm.service.NewsService;
import com.mai.tcm.vo.web.CarouselListDto;
import com.mai.tcm.vo.web.NewsListDto;
import com.mai.tcm.vo.web.NewsListVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/8.
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    private static final Logger logger = Logger.getLogger(NewsController.class);

    @Autowired
    public NewsService newsService;

    /**
     *
     * @param model
     * @return
     * @throws BaseException
     */
    @RequestMapping("/list")
    public String newsList(Model model,HttpServletRequest request) throws BaseException {

        NewsListVo newsListVo = new NewsListVo();

        if(StringUtils.isNotBlank(request.getParameter("newsTitle"))){
            newsListVo.setTitle(request.getParameter("newsTitle"));
            model.addAttribute("newsTitle",request.getParameter("newsTitle"));
        }

        int pageNumber = 1;
        if (StringUtils.isNotBlank(request.getParameter("page"))) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        Page<NewsListVo> page = new Page<NewsListVo>(pageNumber,20);

        List<NewsListVo> newsListVOList = this.newsService.selectByNewsListVoAndPage(page, newsListVo);

        model.addAttribute("newslist", newsListVOList);
        model.addAttribute("page", page.getPageNo());
        model.addAttribute("totalPageSize", page.getTotalPages());
        model.addAttribute("totalsize", page.getTotalCount());
        model.addAttribute("pageMaxSize", page.getPageSize());
        return "/ajax/news/newslist";
    }

    /**
     * 返回json数据
     * @param model
     * @return
     */
    @RequestMapping(value="/listDto", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String carouselListDto(Model model,HttpServletRequest request) {

        NewsListDto newsListDto = new NewsListDto();
        int pageNumber = 1;
        if (StringUtils.isNotBlank(request.getParameter("page"))) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        Page<NewsListDto> page = new Page<NewsListDto>(pageNumber,20);

        List<NewsListDto> newsListDtoList = this.newsService.selectByNewsListDtoAndPage(page, newsListDto);
        String jsonString = JsonHelper.collection2json(newsListDtoList);
        System.out.print(jsonString);
//        logger.debug("数据个数:"+carouselListVOList.size());
//        model.addAttribute("carousellist", newsListDtoList);
        model.addAttribute("page", page.getPageNo());
        model.addAttribute("totalPageSize", page.getTotalPages());
        model.addAttribute("totalsize", page.getTotalCount());
        model.addAttribute("pageMaxSize", page.getPageSize());

//        response.setHeader("Cache-Control", "no-cache");
//        response.setContentType("text/json;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//            out.write(jsonString);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return "jsoncall("+JSON.parseArray(jsonString)+")";
    }

    @RequestMapping(value = "/edit")
    public String edit(Model model,HttpServletRequest request) throws BaseException {
        News news = new News();
        if(StringUtils.isNotBlank(request.getParameter("newsID"))){
            news = newsService.getNewsByID(request.getParameter("newsID"));
        }
        model.addAttribute("news", news);
        return "/ajax/news/news";
    }


    @RequestMapping(value = "/updateStatus")
    @ResponseBody
    public int updateStatus(String newsID,int newsStatus){
        News news = null;
        try {
            news = newsService.getNewsByID(newsID);
            if(news!=null){
                if(News.STATUS_RELEASED == newsStatus){
//                    news.setUplineTime(Calendar.getInstance().getTimeInMillis());
                }
                news.setStatus(newsStatus);
                newsService.updateNews(news);
                return news.getStatus();
            }else{
                return -2;
            }
        } catch (BaseException e) {
            e.printStackTrace();
            return -3;
        }
    }

    @RequestMapping(value = "/addOrUpdateNews")
    @ResponseBody
    public JSONObject addOrUpdateNews(News news,HttpServletRequest request,Model model){
        BaseVo baseVo = new BaseVo();
        try{
            if(StringUtils.isBlank(news.getNewsID())){
                System.out.print("status:"+request.getParameter("status"));
                Calendar ca = Calendar.getInstance();
                news.setCreateTime(ca.getTimeInMillis());
                news.setNewsID(UUIDUtil.getUUID());
                newsService.addNews(news);
            }else{
                newsService.updateNews(news);
            }
            baseVo.setCode(BaseVo.SUCCESS_CODE);
            baseVo.setExt(MenuEnum.TREE_ID_NEWS_LIST.getUrl());
            baseVo.setTreeID(MenuEnum.TREE_ID_NEWS_LIST.getCode());

        }catch (BaseException be){
            logger.error(be);
            baseVo.setCode(BaseVo.FAIL_CODE);
        }
        return (JSONObject) JSON.toJSON(baseVo);
    }

}
