
package com.wxmp.core.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.StringUtils;

import java.util.MissingResourceException;

/**
 * hermit
 */
@Slf4j
public class PropertiesUtil {
    private static final byte[] KEY = {9, -1, 0, 5, 39, 8, 6, 19};

    /**
     * 配置文件
     */
    private static Configuration config;

    static {
        try {
            config = new PropertiesConfiguration("property/smartwx.properties" );
        } catch (ConfigurationException e) {
            log.error("获取配置文件失败，", e);
        }
    }

    /**
     * Get a value based on key , if key does not exist , null is returned
     *
     * @param key
     * @return
     */
    public static String getString(String key) {
        try {
            return config.getString(key);
        } catch (MissingResourceException e) {
            return null;
        }
    }

    /**
     * 根据key获取值
     *
     * @param key
     * @return
     */
    public static int getInt(String key) {
        return config.getInt(key);
    }

    /**
     * 根据key获取值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(String key, int defaultValue) {
        String value = config.getString(key);
        if (StringUtils.isBlank(value)) {
            return defaultValue;
        }
        return Integer.parseInt(value);
    }

    /**
     * 根据key获取值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(String key, boolean defaultValue) {
        String value = config.getString(key);
        if (StringUtils.isBlank(value)) {
            return defaultValue;
        }
        return new Boolean(value);
    }

    public static void main(String[] args) {
        String encrypt = SecurityUtil.encryptDes("buzhidao", KEY);
        System.out.println(encrypt);
        System.out.println(SecurityUtil.decryptDes(encrypt, KEY));
    }
}
