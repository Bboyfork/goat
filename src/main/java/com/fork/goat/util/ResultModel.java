package com.fork.goat.util;

import java.util.HashMap;

/**
 * 返回值封装
 * @author Bboy_fork
 * @date 2020年9月15日17:57:37
 * */
public class ResultModel extends HashMap<String,Object> {
    private static final long serialVersionUID = 1L;

    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    public enum Type{
        /**成功*/
        SUCCESS ("0"),
        /**警告*/
        WARN ("300"),
        /**错误*/
        ERROR ("500");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    /**
     * 初始化一个新的  AjaxResult对象(用途：msg返回值)
     * */
    public ResultModel(Type type , String msg){
        super.put(CODE_TAG,type.value);
        super.put(MSG_TAG,msg);
    }

    public ResultModel(Type type, String msg, Object data){
        super.put(CODE_TAG,type.value);
        super.put(MSG_TAG,msg);
        if(data != null){
            super.put(DATA_TAG,data);
        }
    }

    public ResultModel(Type type, String msg, String dataName, Object data){
        super.put(CODE_TAG,type.value);
        super.put(MSG_TAG,msg);
        if(data != null){
            super.put(dataName,data);
        }
    }

    public static ResultModel success(){
        return success("very nice",null);
    }
    public static ResultModel success(String msg,Object data){
        return new ResultModel(Type.SUCCESS,msg,data);
    }
    public static ResultModel success(String dataName,String msg,Object data){
        return new ResultModel(Type.SUCCESS,"",dataName,data);
    }


    public static ResultModel error(){
        return error("操作失败");
    }
    public static ResultModel error(String msg){
        return error(msg,null);
    }
    public static ResultModel error(String msg,Object data){
        return new ResultModel(Type.ERROR,msg,data);
    }

    public static ResultModel warn(String msg){
        return warn(msg,null);
    }

    public static ResultModel warn(String msg,Object data){
        return new ResultModel(Type.WARN,msg,data);
    }
}
