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
import com.mai.tcm.model.Carousel;
import com.mai.tcm.security.MenuEnum;
import com.mai.tcm.service.CarouselService;
import com.mai.tcm.vo.web.CarouselListDto;
import com.mai.tcm.vo.web.CarouselListVo;
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
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/8.
 */
@Controller
@RequestMapping("/carousel")
public class CarouselController {

    private static final Logger logger = Logger.getLogger(CarouselController.class);

    private static final String CAROUSEL_PIC_PATH = "/images/carousel/";
    @Autowired
    private CarouselService carouselService;



    /**
     *
     * @param model
     * @return
     * @throws com.mai.framework.base.BaseException
     */
    @RequestMapping("/list")
    public String carouselList(Model model,HttpServletRequest request) throws BaseException {

        CarouselListVo carouselListVo = new CarouselListVo();


        if(StringUtils.isNotBlank(request.getParameter("carouselTitle"))){
            carouselListVo.setTitle(request.getParameter("carouselTitle"));
            model.addAttribute("carouselTitle",request.getParameter("carouselTitle"));
        }

        int pageNumber = 1;
        if (StringUtils.isNotBlank(request.getParameter("page"))) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        Page<CarouselListVo> page = new Page<CarouselListVo>(pageNumber,20);

        List<CarouselListVo> carouselListVOList = this.carouselService.selectByCarouselListVoAndPage(page, carouselListVo);

        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        System.out.print("contextPath:"+basePath+",");
       /* System.out.print(JsonHelper.collection2json(carouselListVOList));
        logger.debug("数据个数:"+carouselListVOList.size());*/
        model.addAttribute("carousellist", carouselListVOList);
        model.addAttribute("page", page.getPageNo());
        model.addAttribute("totalPageSize", page.getTotalPages());
        model.addAttribute("totalsize", page.getTotalCount());
        model.addAttribute("pageMaxSize", page.getPageSize());

        return "ajax/carousel/carousellist";
    }


    /**
     * 返回json数据
     * @param model
     * @return
     * @throws com.mai.framework.base.BaseException
     */
    @RequestMapping(value="/listDto", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String carouselListDto(Model model,HttpServletRequest request) throws BaseException {

        CarouselListDto carouselListDto = new CarouselListDto();


        if(StringUtils.isNotBlank(request.getParameter("carouselTitle"))){
            carouselListDto.setTitle(request.getParameter("carouselTitle"));
            model.addAttribute("carouselTitle",request.getParameter("carouselTitle"));
        }

        int pageNumber = 1;
        if (StringUtils.isNotBlank(request.getParameter("page"))) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        Page<CarouselListDto> page = new Page<CarouselListDto>(pageNumber,20);

        List<CarouselListDto> carouselListVOList = this.carouselService.selectByCourseListDtoAndPage(page, carouselListDto);
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
        System.out.print("contextPath:"+basePath+",");
        for (CarouselListDto listDto :carouselListVOList){
            listDto.setPicUrl(basePath+listDto.getPicUrl());
            System.out.print(listDto.getPicUrl());
        }
        String jsonString = JsonHelper.collection2json(carouselListVOList);
//        System.out.print(jsonString);
//        logger.debug("数据个数:"+carouselListVOList.size());
        model.addAttribute("carousellist", carouselListVOList);
        model.addAttribute("page", page.getPageNo());
        model.addAttribute("totalPageSize", page.getTotalPages());
        model.addAttribute("totalsize", page.getTotalCount());
        model.addAttribute("pageMaxSize", page.getPageSize());

        return "jsoncallback("+JSON.parseArray(jsonString)+")";

    }


    @RequestMapping(value = "/edit")
    public String edit(Model model,HttpServletRequest request) throws BaseException {
        Carousel carousel = new Carousel();
        if(StringUtils.isNotBlank(request.getParameter("carouselID"))){
            carousel = carouselService.getCarouselByID(request.getParameter("carouselID"));
        }
        model.addAttribute("carousel", carousel);
        return "/ajax/carousel/carousel";
    }


    @RequestMapping(value = "/updateStatus")
    @ResponseBody
    public int updateStatus(String carouselID,int carouselStatus){
        Carousel carousel = null;
        try {
            carousel = carouselService.getCarouselByID(carouselID);
            if(carousel!=null){
                if(Carousel.STATUS_RELEASED == carouselStatus){
                    carousel.setUplineTime(Calendar.getInstance().getTimeInMillis());
                }
                carousel.setStatus(carouselStatus);
                carouselService.updateCarousel(carousel);
                return carousel.getStatus();
            }else{
                return -2;
            }
        } catch (BaseException e) {
            e.printStackTrace();
            return -3;
        }
    }

    @RequestMapping(value = "/addOrUpdateCarousel")
    @ResponseBody
    public JSONObject addOrUpdateCarousel(@RequestParam(required = false) MultipartFile Filedata,Carousel carousel,HttpServletRequest request,Model model){
        BaseVo baseVo = new BaseVo();
        try{
            Calendar ca = Calendar.getInstance();
//            carousel.setCreatePersonName(CurrentUser.getUserName());
//            carousel.setCreatePersonID(CurrentUser.getCurrentPersonId());
            if(Carousel.STATUS_RELEASED == carousel.getStatus()){
                carousel.setUplineTime(ca.getTimeInMillis());
            }
            /*if(Filedata!=null){
                String fileName = Filedata.getOriginalFilename();
                if(!StringUtils.isBlank(fileName)){
                    String newFilename = UUIDUtil.getUUID();
                    *//*把图片存放在本地*//*
//                    uploadManager.upload(Filedata.getBytes(), newFilename);
                    carousel.setPicUrl(newFilename);
                }
            }*/
            if(Filedata!=null){
                String fileName = Filedata.getOriginalFilename();
                if (!StringUtils.isBlank(fileName)){
                    String suffix = fileName.substring(fileName.lastIndexOf("."));
//                        CAROUSEL_PIC_PATH 文件路径
                    String path = request.getSession().getServletContext().getRealPath(CAROUSEL_PIC_PATH);
                    String newFileName = UUIDUtil.getUUID() + suffix;
                    File targetFile = new File(path, newFileName);
                    if(!targetFile.exists()){
                        targetFile.mkdirs();
                    }
                    try {
                        Filedata.transferTo(targetFile);
                        carousel.setPicUrl(CAROUSEL_PIC_PATH+targetFile.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
            if(StringUtils.isBlank(carousel.getCarouselID())){
                carousel.setCreateTime(ca.getTimeInMillis());
                carousel.setCarouselID(UUIDUtil.getUUID());
                carousel.setTargetType(Carousel.TARGET_TYPE_URL);//跳转类型:url
                carouselService.addCarousel(carousel);
            }else{
                carouselService.updateCarousel(carousel);
            }
            baseVo.setCode(BaseVo.SUCCESS_CODE);
            baseVo.setExt(MenuEnum.TREE_ID_CAROUSEL_LIST.getUrl());
            baseVo.setTreeID(MenuEnum.TREE_ID_CAROUSEL_LIST.getCode());
        } catch (BaseException be){
            logger.error(be);
            baseVo.setCode(BaseVo.FAIL_CODE);
        }
        return (JSONObject) JSON.toJSON(baseVo);
    }

}
