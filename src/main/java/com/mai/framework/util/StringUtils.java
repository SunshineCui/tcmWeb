package com.mai.framework.util;


import java.io.UnsupportedEncodingException;

/**
 * Created by fengdzh on 2015/10/3.
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {
    /**
     * 按字节截取字符串
     * @param text  要截取的字符串
     * @param length 长度
     * @param encode 编码
     * @param tail 补充字符
     * @return
     */
    public static String substring(String text, int length, String encode, String tail){
        if (text == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int currentLength = 0;
            for (char c : text.toCharArray()) {
                currentLength += String.valueOf(c).getBytes(encode).length;
                if (currentLength <= length) {
                    sb.append(c);
                } else {
                    if(StringUtils.isNotBlank(tail)){
                        sb.append(tail);
                    }
                    break;
                }
            }
            if(sb.length() < text.length()){

            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

}
