package com.mai.framework.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;


/**
 * JSON和JAVA的POJO的相互转换
 * 
 * @author Jinwei.Yao
 * @date 2014-9-19下午1:12:07
 * @Copyright(c) Beijing Seeyon Software Co.,LTD
 */
public final class JsonHelper {
    /**
     * json字符串转为对象List
     * 默认支持三种时间格式："yyyy-MM-dd HH:mm:ss.SSS"、 "yyyy-MM-dd HH:mm:ss"、"yyyy-MM-dd"
     * 可通过JSON.DEFFAULT_DATE_FORMAT指定
     * @param json
     * @param clazz
     * @return
     */
    public static <T> List<T> json2Collection(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }

    /**
     * json字符串转为对象
     * 默认支持三种时间格式："yyyy-MM-dd HH:mm:ss.SSS"、 "yyyy-MM-dd HH:mm:ss"、"yyyy-MM-dd"
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T json2Object(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * json字符串转为hashmap
     * @param json
     * @return
     */
    public static HashMap json2HashMap(String json) {
        return JSON.parseObject(json, HashMap.class);
    }
    
    /**
     * 对象数组转为json字符串
     * @param object
     * @return
     */
    public static String collection2json(Object object) {
        return JSON.toJSONString(object);
    }
    
    /**
     * 对象数组转为json字符串
     * @param object
     * @param dateFormat 指定时间格式，如： "yyyy-MM-dd HH:mm:ss.SSS"
     * @return
     */
    public static String collection2json(Object object,String dateFormat) {
        return JSON.toJSONStringWithDateFormat(object, dateFormat);
    }
    
    /**
     * 对象转为json字符串
     * @param object
     * @return
     */
    public static String object2json(Object object) {
        return JSON.toJSONString(object);
    }
    
    /**
     * 对象转为json字符串,
     * @param object
     * @param dateFormat 指定时间格式，如： "yyyy-MM-dd HH:mm:ss.SSS"
     * @return
     */
    public static String object2json(Object object,String dateFormat) {
        return JSON.toJSONStringWithDateFormat(object, dateFormat);
    }
    
    
   /* public static void main(String[] args) throws Exception {
        String jsonString ="[{\"companyID\":\"917336721886984876847853\",\"companyName\":\"测试专用ewq\",\"createTime\":1388549532000,\"createUserID\":\"7281244289843347475\",\"createUserName\":\"测试1\",\"headPicID\":\"7279570413968770998\",\"isSigned\":\"0\",\"personID\":\"7279570413968770998\",\"personName\":\"测试4\",\"signPersonID\":\"2524164954471221060\",\"signTime\":null,\"signWallID\":\"665752231033456037\"}]";
        List<SignPerson>  list = JSON.parseArray(jsonString, SignPerson.class);
        System.out.println(JSON.toJSONString(list));
        
        System.out.println(object2json(list.get(0)));
        SignPerson person = (SignPerson)json2Object(object2json(list.get(0)),SignPerson.class);
        System.out.println(object2json(person));
        //List<SignPerson> list2 = testJackson(jsonString, SignPerson.class);
    }*/
    
//    public static <T> List<T> testJackson(String json, Class<T> valueClz) throws JsonParseException, JsonMappingException, IOException{
//        import org.codehaus.jackson.JsonParseException;
//        import org.codehaus.jackson.map.JsonMappingException;
//        import org.codehaus.jackson.map.ObjectMapper;
//        import org.codehaus.jackson.type.TypeReference;
//
//        ObjectMapper mapper = new ObjectMapper();  
//        return mapper.readValue(json, new TypeReference<List<T>>() {}); 
//    }
}
