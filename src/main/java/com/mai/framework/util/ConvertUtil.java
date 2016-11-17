package com.mai.framework.util;

/**
 * ConvertUtil
 *
 * @author Yao Jinwei
 * @date 2016/3/30
 */
public class ConvertUtil {
    /**
     * 将字符串转换成null
     * @param value
     * @return
     */
    public static Integer toInteger(Object value){
        if(value == null){
            return null;
        }
        if(StringUtils.isNotBlank(value.toString())){
            return Integer.parseInt(value.toString());
        }
        else{
            return null;
        }
    }

    public static Integer toInteger(String value){
        return toInteger((Object)value);
    }

    /**
     * 字符串转为double
     * @param value
     * @return
     */
    public static Double toDouble(Object value){
        if(value == null){
            return null;
        }
        if(StringUtils.isNotBlank(value.toString())){
            return Double.parseDouble(value.toString());
        }
        else{
            return null;
        }
    }

    /**
     * 字符串转为long
     * @param value
     * @return
     */
    public static Long toLong(Object value){
        if(value == null){
            return null;
        }
        if(StringUtils.isNotBlank(value.toString())){
            return Long.parseLong(value.toString());
        }
        else{
            return null;
        }
    }

    public static void main(String[] args) {
        String arg = "121";
        System.out.println(ConvertUtil.toInteger(arg));
    }
}
