package com.lxgzhw.web.utils;

import sun.misc.BASE64Decoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/*
解决浏览器的文件名兼容问题
 */
public class DownloadUtils {
    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            //1.IE浏览器
            filename = URLEncoder.encode(filename, "utf8");
            filename = filename.replace("+", " ");
        } else {
            //2.其他浏览器
            filename = URLEncoder.encode(filename, "utf8");
        }

        return filename;
    }
}
