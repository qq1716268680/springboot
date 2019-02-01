package com.example.yxw.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 获取系统配置文件，读取相关的配置
 */
public class SysConfigUtil {
    /**
     * 日志
     */
    private static final Logger TRACER = LogManager.getLogger(SysConfigUtil.class);
    /**
     * 系统默认配置文件
     */
    private static final String SYS_DEFAULT_CONFIG_FILE = SysConfigConstant.CONFIG_PROP_FILEPATH;
    /**
     * 配置缓存
     */
    private static final ConcurrentHashMap<String, Properties> CONFIG_MAP = new ConcurrentHashMap();

    public static final String NUC_NODE_NAME = getProperty("nuc.node.name");

    public static final String NUC_IP = getProperty("nuc.ip");

    /**
     * 从系统默认配置文件中获取配置项
     *
     * @param strKey 配置项key
     * @return 配置项值
     */
    public static String getProperty(String strKey) {
        return getPropertyByFilePath(SYS_DEFAULT_CONFIG_FILE, strKey);
    }

    /**
     * 从指定的配置文件（classpath）中获取配置项
     *
     * @param configPath 配置文件路径
     * @param strKey     配置项key
     * @return 配置项值
     */
    public static String getPropertyByClassPath(String configPath, String strKey) {
        String strValue = "";
        Properties properties = parseConfigProperty(configPath, true);
        if (properties != null) {
            Object obj = properties.get(strKey);
            if (obj != null) {
                strValue = String.valueOf(obj);
            }
        }
        return strValue;
    }

    /**
     * 从指定的配置文件（文件系统）中获取配置项
     *
     * @param configPath 配置文件路径
     * @param strKey     配置项key
     * @return 配置项值
     */
    public static String getPropertyByFilePath(String configPath, String strKey) {
        String strValue = "";
        Properties properties = parseConfigProperty(configPath, false);
        if (properties != null) {
            strValue = (String) properties.get(strKey);
        }
        return strValue;
    }

    /**
     * 从指定的配置文件（文件系统）中获取配置项
     *
     * @param configPath 配置文件路径
     * @param strKey     配置项key
     * @param flag       读内存还是读硬盘 false读硬盘  true读内存
     * @return 配置项值
     */
    public static String getPropertyByFilePath(String configPath, String strKey, boolean flag) {
        String strValue = "";
        Properties properties = parseConfigProperty(configPath, false, flag);
        if (properties != null) {
            strValue = (String) properties.get(strKey);
        }
        return strValue;
    }

    /**
     * 从系统默认配置文件中获取配置项
     *
     * @param strKey       配置项key
     * @param defaultValue 默认值
     * @return 配置项值
     */
    public static String getProperty(String strKey, String defaultValue) {
        String strValue = getProperty(strKey);
        if (StringUtil.isEmpty(strValue)) {
            strValue = defaultValue;
        }
        return strValue;
    }

    /**
     * 根据文件路径或路径类型解析properties文件
     *
     * @param configPath    文件路径
     * @param fromClassPath 文件系统还是classpath
     * @return 配置项集合
     */
    private static Properties parseConfigProperty(String configPath, boolean fromClassPath) {
        String configPathKey = configPath + ":" + fromClassPath;
        if (!CONFIG_MAP.containsKey(configPathKey)) {
            synchronized (SysConfigUtil.class) {
                if (!CONFIG_MAP.containsKey(configPathKey)) {
                    Properties properties = new Properties();
                    try {
                        if (fromClassPath) {
                            properties.load(
                                    Thread.currentThread().getContextClassLoader().getResourceAsStream(configPath));
                        } else {
                            properties.load(new FileInputStream(configPath));
                        }
                        CONFIG_MAP.put(configPathKey, properties);
                    } catch (IOException e) {
                        // 不往外抛出异常
                        TRACER.error(configPath + " not found!");
                    }
                }
            }
        }
        return CONFIG_MAP.get(configPathKey);
    }

    /**
     * 根据文件路径或路径类型解析properties文件
     *
     * @param configPath    文件路径
     * @param fromClassPath 文件系统还是classpath
     * @param flag          读内存还是读硬盘  false读硬盘  true读内存
     * @return 配置项集合
     */
    private static Properties parseConfigProperty(String configPath, boolean fromClassPath, boolean flag) {
        if (flag) {
            return parseConfigProperty(configPath, fromClassPath);
        }
        synchronized (SysConfigUtil.class) {
            Properties properties = new Properties();
            try {
                if (fromClassPath) {
                    properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(configPath));
                } else {
                    properties.load(new FileInputStream(configPath));
                }
                return properties;
            } catch (IOException e) {
                // 不往外抛出异常
                TRACER.error(configPath + " not found!");
            }
        }
        return null;
    }

    /**
     * 根据文件路径或路径类型获取配置项
     *
     * @param configPath    配置文件路径
     * @param fromClassPath 文件系统还是classpath
     * @return map
     */
    public static Map getConfigProperties(String configPath, boolean fromClassPath) {
        Map<String, String> map = new HashMap();
        Properties properties = parseConfigProperty(configPath, fromClassPath);
        if (MapUtil.isNotEmpty(properties)) {
            Set<String> propNameList = properties.stringPropertyNames();
            if (!propNameList.isEmpty()) {
                String propValue;
                for (String propName : propNameList) {
                    propValue = properties.getProperty(propName);
                    map.put(propName, propValue);
                }
            }
        }
        return map;
    }

    /**
     * 修改或添加键值对 如果key存在，修改, 反之，添加。
     *
     * @param key   键
     * @param value 键对应的值
     */
    public static void updateProperty(String path, String key, String value, String comments) {
        Properties properties = new Properties();
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            InputStream fis = new FileInputStream(file);
            properties.load(fis);
            //一定要在修改值之前关闭fis
            fis.close();
            properties.setProperty(key, value);
            //保存，并加入注释
            OutputStream fos = new FileOutputStream(path);
            properties.store(fos, comments);
            fos.close();
        } catch (IOException e) {
            TRACER.error("fail write properties about " + key, e);
        }
    }

    public static void updateProperty(String path, String key, String value) {
        updateProperty(path, key, value, null);
    }

    public static void updateProperty(String key, String value) {
        updateProperty(SYS_DEFAULT_CONFIG_FILE, key, value, null);
    }

}
