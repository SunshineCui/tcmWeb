package com.mai.tcm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mai.framework.base.BaseException;
import com.mai.framework.feature.mybatis.Page;
import com.mai.framework.util.JsonHelper;
import com.mai.framework.util.StringUtils;
import com.mai.framework.util.UUIDUtil;
import com.mai.tcm.model.BaseVo;
import com.mai.tcm.model.News;
import com.mai.tcm.model.TopColumn;
import com.mai.tcm.security.MenuEnum;
import com.mai.tcm.service.ColumnService;
import com.mai.tcm.service.NewsService;
import com.mai.tcm.service.TopColumnService;
import com.mai.tcm.vo.web.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/8.
 */
@Controller
@RequestMapping("/topColumn")
public class TopColumnController {
    private static final Logger logger = Logger.getLogger(TopColumnController.class);

    @Autowired
    public TopColumnService topColumnService;

    @Autowired
    public ColumnService columnService;

    /**
     *
     * @param model
     * @return
     * @throws com.mai.framework.base.BaseException
     */
    @RequestMapping("/list")
    public String topColumnList(Model model,HttpServletRequest request) throws BaseException {

        TopColumnListVo topColumnListVo = new TopColumnListVo();

        if(StringUtils.isNotBlank(request.getParameter("topColumnTitle"))){
            topColumnListVo.setTitle(request.getParameter("topColumnTitle"));
            model.addAttribute("topColumnTitle",request.getParameter("topColumnTitle"));
        }

        int pageNumber = 1;
        if (StringUtils.isNotBlank(request.getParameter("page"))) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        Page<TopColumnListVo> page = new Page<TopColumnListVo>(pageNumber,20);

        List<TopColumnListVo> topColumnListVoList = this.topColumnService.selectByTopColumnListVoAndPage(page, topColumnListVo);

        model.addAttribute("topColumnlist", topColumnListVoList);
        model.addAttribute("page", page.getPageNo());
        model.addAttribute("totalPageSize", page.getTotalPages());
        model.addAttribute("totalsize", page.getTotalCount());
        model.addAttribute("pageMaxSize", page.getPageSize());
        return "/ajax/topColumn/topColumnlist";
    }

    /**
     * 返回json数据
     * @param model
     * @return
     */
    @RequestMapping(value="/listDto", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String carouselListDto(Model model,HttpServletRequest request) {

        TopColumnListDto topColumnListDto = new TopColumnListDto();
        int pageNumber = 1;
//        获取二级栏目
        ColumnListDto columnListDto = new ColumnListDto();
        Page<ColumnListDto> columnListDtoPage = new Page<ColumnListDto>(pageNumber,20);
        List<ColumnListDto> columnListDtoList = this.columnService.selectByColumnListDtoAndPage(columnListDtoPage, columnListDto);

        if (StringUtils.isNotBlank(request.getParameter("page"))) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        Page<TopColumnListDto> page = new Page<TopColumnListDto>(pageNumber,20);

        List<TopColumnListDto> topColumnListDtos = this.topColumnService.selectByTopColumnListDtoAndPage(page, topColumnListDto);
        for (TopColumnListDto listDto:topColumnListDtos){
            List<ColumnListDto> tempColumnListVoList = new ArrayList<ColumnListDto>();
            for(ColumnListDto columnList:columnListDtoList){
                if (columnList.getTopColumnID().equals(listDto.getTopColumnID()) ){
                    tempColumnListVoList.add(columnList);
                }
            }
            listDto.setColumnListVoList(tempColumnListVoList);
        }
        String jsonString = JsonHelper.collection2json(topColumnListDtos);
        System.out.print(jsonString);
//        logger.debug("数据个数:"+carouselListVOList.size());
//        model.addAttribute("carousellist", newsListDtoList);
        model.addAttribute("page", page.getPageNo());
        model.addAttribute("totalPageSize", page.getTotalPages());
        model.addAttribute("totalsize", page.getTotalCount());
        model.addAttribute("pageMaxSize", page.getPageSize());


        return "jsoncalltitle("+JSON.parseArray(jsonString)+")";
    }

    @RequestMapping(value = "/edit")
    public String edit(Model model,HttpServletRequest request) throws BaseException {
        TopColumn topColumn = new TopColumn();
        if(StringUtils.isNotBlank(request.getParameter("topColumnID"))){
            topColumn = topColumnService.getTopColumnByID(request.getParameter("topColumnID"));
        }
        model.addAttribute("topColumn", topColumn);
        return "/ajax/topColumn/topColumn";
    }


    @RequestMapping(value = "/updateStatus")
    @ResponseBody
    public int updateStatus(String topColumnID,int topColumnStatus){
        TopColumn topColumn = null;
        try {
            topColumn = topColumnService.getTopColumnByID(topColumnID);
            if(topColumn!=null){
                if(News.STATUS_RELEASED == topColumnStatus){
//                    news.setUplineTime(Calendar.getInstance().getTimeInMillis());
                }
                topColumn.setStatus(topColumnStatus);
                topColumnService.updateTopColumn(topColumn);
                return topColumn.getStatus();
            }else{
                return -2;
            }
        } catch (BaseException e) {
            e.printStackTrace();
            return -3;
        }
    }

    @RequestMapping(value = "/addOrUpdateTopColumn")
    @ResponseBody
    public JSONObject addOrUpdateTopColumn(TopColumn topColumn,HttpServletRequest request,Model model){
        BaseVo baseVo = new BaseVo();
        try{
            if(StringUtils.isBlank(topColumn.getTopColumnID())){
                System.out.print("status:"+request.getParameter("status"));
                Calendar ca = Calendar.getInstance();
                topColumn.setCreateTime(ca.getTimeInMillis());
                topColumn.setTopColumnID(UUIDUtil.getUUID());
                topColumnService.addTopColumn(topColumn);
            }else{
                topColumnService.updateTopColumn(topColumn);
            }
            baseVo.setCode(BaseVo.SUCCESS_CODE);
            baseVo.setExt(MenuEnum.TREE_ID_TOPCOLUMN_LIST.getUrl());
            baseVo.setTreeID(MenuEnum.TREE_ID_TOPCOLUMN_LIST.getCode());

        }catch (BaseException be){
            logger.error(be);
            baseVo.setCode(BaseVo.FAIL_CODE);
        }
        return (JSONObject) JSON.toJSON(baseVo);
    }

}
