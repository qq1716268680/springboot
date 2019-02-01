package com.example.yxw.util;

/**
 * @author yangz
 */
public class ErrorCode {

    /**
     * 成功
     */
    public final static String SUCCESS = "10001";

    /**
     * 系统异常
     */
    public final static String SYSTEM_EXCEPTION = "EC000001";

    /**
     * 未知异常
     */
    public final static String UNKNOWN = "EC000002";

    /**
     * 查询条件为空
     */
    public final static String QUERY_CONDITION_IS_NULL = "EC000003";

    /**
     * 未认证
     */
    public final static String NO_AUTHORIZATION = "EC000100";

    /**
     * 节点类型，节点名称不能为空
     */
    public final static String CONDITION_NODETYPE_NODENAME_MUST_NOT_NULL = "EC020101";

    /**
     * 用户信息不能为空
     */
    public final static String USER_INFO_IS_NULL = "EC010001";
    /**
     * 用户名或密码错误
     */
    public final static String USER_INFO_IS_WRONG = "EC010002";

    /**
     * nodeName不存在
     */
    public final static String NODE_NAME_IS_NOT_EXIST = "EC030001";
    /**
     * nodeName不能为空
     */
    public final static String NODE_TYPE_MUST_NOT_NULL = "EC030002";

    /**
     * nodeName不能为空
     */
    public final static String NODE_NAME_MUST_NOT_NULL = "EC030003";

    /**
     * 门限获取失败
     */
    public final static String FAIL_TO_GET_THRESHOLD = "EC040001";



}
