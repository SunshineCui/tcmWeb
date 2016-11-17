package com.mai.tcm.security;

/**
 * MenuEnum
 * 菜单枚举类
 * @author Yao Jinwei
 * @date 2016/5/31
 */
public enum MenuEnum {
    TREE_ID_CAROUSEL_LIST("carouselList","/w/carousel/list"),
    TREE_ID_CAROUSEL("carouselList","/w/carousel/edit"),
    TREE_ID_SCHOOL_LIST("schoolList","/w/school/list"),
    TREE_ID_SCHOOL("schoolList","/w/school/edit"),
    TREE_ID_NEWS_LIST("newsList","/w/news/list"),
    TREE_ID_NEWS("newsList","/w/news/edit"),
    FILE_UPLOAD_EMO("fileuploaddemo","/w/demo/fileupload");


    String code;
    String url;

    MenuEnum(String code, String url){
        this.code = code;
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public String getUrl() {
        return url;
    }
}
