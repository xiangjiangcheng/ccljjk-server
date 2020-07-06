package com.ccljjk.server.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Iterator;
import java.util.Map;

/**
 * bean转换工具类
 *
 * @author Xiang Jiangcheng
 * @date 2020/7/1 10:49
 */
public class BeanUtil {

    /**
     * 把一个bean中的属性转化到map中
     *
     * @param bean       bean对象
     * @param properties 存放bean中属性的map对象
     */
    public static void beanToMap(Object bean, Map properties) {
        if (bean == null || properties == null) {
            return;
        }

        try {
            Map map = BeanUtils.describe(bean);
            map.remove("class");
            for (Iterator iter = map.keySet().iterator(); iter.hasNext(); ) {
                String key = (String) iter.next();
                Object value = map.get(key);
                properties.put(key, value);
            }
        } catch (Exception ex) {
            System.out.println("读取bean属性出错");
            ex.printStackTrace();
        }
    }

    /**
     * 把一个map中的所有属性值设置到bean中
     *
     * @param properties 含有属性的map对象
     * @param bean       需要被设置属性的对象
     */
    public static void mapToBean(Map properties, Object bean) {
        if (properties == null || bean == null) {
            return;
        }
        try {
            for (Iterator iter = properties.keySet().iterator(); iter.hasNext(); ) {
                String key = (String) iter.next();
                Object value = properties.get(key);
                BeanUtils.setProperty(bean, key, value);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
