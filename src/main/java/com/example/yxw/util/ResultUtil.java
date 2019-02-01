package com.example.yxw.util;



import javax.servlet.http.HttpServletRequest;

/**
 * @author yangz
 */
public class ResultUtil {

    /**
     * 成功返回
     *
     * @param data 数据
     * @return
     */
    public static Result success(HttpServletRequest request, Object data) {
//        return new Result(ErrorCode.SUCCESS, data, request);
        return new Result(ErrorCode.SUCCESS, data, request);
    }

    /**
     * 成功返回
     *
     * @return
     */
    public static Result success(HttpServletRequest request) {
        return new Result(ErrorCode.SUCCESS, null, request);
    }

    /**
     * 系统异常
     *
     * @return
     */
    public static Result systemEx(HttpServletRequest request) {
        return new Result(ErrorCode.SYSTEM_EXCEPTION, null, request);
    }

    /**
     * 返回失败
     *
     * @param errorCode 错误码
     * @param data      数据
     * @return
     */
    public static Result failed(HttpServletRequest request, String errorCode, Object data) {
        return new Result(errorCode, data, request);
    }

    /**
     * 返回失败
     *
     * @param errorCode 错误码
     * @return
     */
    public static Result failed(HttpServletRequest request, String errorCode) {
        return new Result(errorCode, null, request);
    }


}
