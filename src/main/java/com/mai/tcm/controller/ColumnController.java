package com.mai.tcm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mai.framework.base.BaseException;
import com.mai.framework.feature.mybatis.Page;
import com.mai.framework.util.StringUtils;
import com.mai.framework.util.UUIDUtil;
import com.mai.tcm.model.BaseVo;
import com.mai.tcm.model.Column;
import com.mai.tcm.model.News;
import com.mai.tcm.security.MenuEnum;
import com.mai.tcm.service.ColumnService;
import com.mai.tcm.service.TopColumnService;
import com.mai.tcm.vo.web.ColumnListVo;
import com.mai.tcm.vo.web.TopColumnListVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.List;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/8.
 */
@Controller
@RequestMapping("/column")
public class ColumnController {
    private static final Logger logger = Logger.getLogger(ColumnController.class);

    @Autowired
    public ColumnService columnService;

    @Autowired
    public TopColumnService topColumnService;
    /**
     *
     * @param model
     * @return
     * @throws com.mai.framework.base.BaseException
     */
    @RequestMapping("/list")
    public String columnList(Model model,HttpServletRequest request) throws BaseException {

        ColumnListVo columnListVo = new ColumnListVo();

        if(StringUtils.isNotBlank(request.getParameter("columnTitle"))){
            columnListVo.setTitle(request.getParameter("columnTitle"));
            model.addAttribute("columnTitle",request.getParameter("columnTitle"));
        }

        int pageNumber = 1;
        if (StringUtils.isNotBlank(request.getParameter("page"))) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        Page<ColumnListVo> page = new Page<ColumnListVo>(pageNumber,20);

        List<ColumnListVo> columnListVoList = this.columnService.selectByColumnListVoAndPage(page, columnListVo);

        model.addAttribute("columnlist", columnListVoList);
        model.addAttribute("page", page.getPageNo());
        model.addAttribute("totalPageSize", page.getTotalPages());
        model.addAttribute("totalsize", page.getTotalCount());
        model.addAttribute("pageMaxSize", page.getPageSize());
        return "/ajax/column/columnlist";
    }

    /**
     * 返回json数据
     * @param model
     * @return
     */
//    @RequestMapping(value="/listDto", produces = "text/html;charset=UTF-8")
//    @ResponseBody
//    public String carouselListDto(Model model,HttpServletRequest request) {

//        NewsListDto newsListDto = new NewsListDto();
//        int pageNumber = 1;
//        if (StringUtils.isNotBlank(request.getParameter("page"))) {
//            pageNumber = Integer.parseInt(request.getParameter("page"));
//        }
//        Page<NewsListDto> page = new Page<NewsListDto>(pageNumber,20);
//
//        List<NewsListDto> newsListDtoList = this.columnService.selectByNewsListDtoAndPage(page, newsListDto);
//        String jsonString = JsonHelper.collection2json(newsListDtoList);
//        System.out.print(jsonString);
////        logger.debug("数据个数:"+carouselListVOList.size());
////        model.addAttribute("carousellist", newsListDtoList);
//        model.addAttribute("page", page.getPageNo());
//        model.addAttribute("totalPageSize", page.getTotalPages());
//        model.addAttribute("totalsize", page.getTotalCount());
//        model.addAttribute("pageMaxSize", page.getPageSize());
//
//
//        return "jsoncall("+JSON.parseArray(jsonString)+")";
//    }

    @RequestMapping(value = "/edit")
    public String edit(Model model,HttpServletRequest request) throws BaseException {
        Column column = new Column();

        if(StringUtils.isNotBlank(request.getParameter("columnID"))){
            column = columnService.getColumnByID(request.getParameter("columnID"));
        }else{
            int pageNumber = 1;
            Page<TopColumnListVo> page = new Page<TopColumnListVo>(pageNumber,20);
            TopColumnListVo topColumnListVo = new TopColumnListVo();
            List<TopColumnListVo> topColumnListVoList = this.topColumnService.selectByTopColumnListVoAndPage(page, topColumnListVo);
            model.addAttribute("top_columnList", topColumnListVoList);
        }
        model.addAttribute("column", column);
        return "/ajax/column/column";
    }


    @RequestMapping(value = "/updateStatus")
    @ResponseBody
    public int updateStatus(String columnID,int columnStatus){
        Column column = null;
        try {
            column = columnService.getColumnByID(columnID);
            if(column!=null){
                if(News.STATUS_RELEASED == columnStatus){
//                    news.setUplineTime(Calendar.getInstance().getTimeInMillis());
                }
                column.setStatus(columnStatus);
                columnService.updateColumn(column);
                return column.getStatus();
            }else{
                return -2;
            }
        } catch (BaseException e) {
            e.printStackTrace();
            return -3;
        }
    }

    @RequestMapping(value = "/addOrUpdateColumn")
    @ResponseBody
    public JSONObject addOrUpdatecolumn(Column column,HttpServletRequest request,Model model){
        BaseVo baseVo = new BaseVo();
        try{
            if(StringUtils.isBlank(column.getColumnID())){
                System.out.print("status:"+request.getParameter("status"));
                Calendar ca = Calendar.getInstance();
                column.setCreateTime(ca.getTimeInMillis());
                column.setColumnID(UUIDUtil.getUUID());
                columnService.addColumn(column);
            }else{
                columnService.updateColumn(column);
            }
            baseVo.setCode(BaseVo.SUCCESS_CODE);
            baseVo.setExt(MenuEnum.TREE_ID_COLUMN_LIST.getUrl());
            baseVo.setTreeID(MenuEnum.TREE_ID_COLUMN_LIST.getCode());

        }catch (BaseException be){
            logger.error(be);
            baseVo.setCode(BaseVo.FAIL_CODE);
        }
        return (JSONObject) JSON.toJSON(baseVo);
    }

}
