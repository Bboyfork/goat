package com.fork.goat.util;

import java.util.HashMap;

public class MairuiSendUtil {
    static HashMap nullHashMap = new HashMap();

    public static String send(String url){
        return HttpClientUtil.sendGet(url,"UTF-8",null,nullHashMap);
    }

}
