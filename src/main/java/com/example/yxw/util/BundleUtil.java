package com.example.yxw.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author yangz
 */
public class BundleUtil {

    private final static Logger LOGGER = LogManager.getLogger(BundleUtil.class);

    /**
     * 获取国际化资源
     *
     * @param request HttpServletRequest
     * @param code    资源key
     * @return 国际化字符串
     */
    public static String getMessage(HttpServletRequest request, String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        if (request == null) {
            String language = SysConfigUtil.getProperty("language");
            String[] split = language.split("_");

            Locale locale = new Locale(split[0], split[1]);
            String pathStr = SysConfigUtil.getProperty("resource.path");
            String[] paths = pathStr.split(",");
            String retStr = code;

            boolean found = false;
            for (String resPath : paths) {
                try {
                    ResourceBundle resourceBundle = ResourceBundle.getBundle(resPath, locale);
                    String result = StringUtil.replaceNull(resourceBundle.getString(code));
                    if (StringUtils.isNotEmpty(result)) {
                        retStr = result;
                        found = true;
                        break;
                    }
                } catch (Exception e) {
                    LOGGER.debug(e.getMessage());
                }
            }
            if (!found) {
                LOGGER.debug("Message key " + code + " is not found in resource files.");
            }
            return retStr;
        }
        RequestContext rc = new RequestContext(request);
        return rc.getMessage(code);
    }
}
