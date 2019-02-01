package com.example.yxw.util;

/**
 * @author yangz
 */
public class SysConfigConstant {

    /**
     * 配置文件路径
     */
    public final static String CONFIG_PROP_FILEPATH = "config/sysconfig.properties";

    /**
     * jetty端口号
     */
    public final static String JETTY_SERVER_PORT = "jetty.port";
    /**
     * webSocket-server端口号
     */
    public final static String WEB_SOCKET_PORT = "webSocket.port";
    /**
     * collector-server端口号
     */
    public final static String NETTY_SERVER_PORT = "collector.port";
    /**
     * 用户信息
     */
    public final static String USER_SESSION_KEY = "userInfo";
    /**
     * EhCache缓存基础数据的name
     */
    public final static String BASIC_DATA = "BASIC_DATA";
    /**
     * EhCache缓存进程门限数据的key
     */
    public final static String PROCESS_THRESHOLD_INFO = "PROCESS_THRESHOLD_INFO";
    /**
     * mongodb信息
     */
    public final static String MONGODB_IP = "mongodb.ip";
    public final static String MONGODB_ACCOUNT = "mongodb.account";
    public final static String MONGODB_PASSWORD = "mongodb.password";
//    public final static String MONGODB_PROCESSTHRESHOLD = "mongodb.processthreshold";

    /**
     * process.csv文件路径
     */
    public final static String PROCESS_CSV_FILEPATH = "config/process.csv";

}