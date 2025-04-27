package com.ex.mytools.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author RedWheat
 * @date 2025/2/12 10:13
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {
    private static final String PROD_ENVIRONMENT_CODE = "prod";
    private static ApplicationContext context = null;

    public SpringContextUtils() {
    }

    public void setApplicationContext(ApplicationContext applicationContextSup) throws BeansException {
        context = applicationContextSup;
    }

    public static ApplicationContext acquireContext() {
        return context;
    }

    public static <T> T getBean(String beanName) {
        return (T) context.getBean(beanName);
    }

    public static <T> Set<T> getBean(Class<T> clazz, String beanName, boolean enablePattern) {
        return (Set)context.getBeansOfType(clazz).entrySet().stream().filter((e) -> {
            return enablePattern ? ((String)e.getKey()).toLowerCase().contains(beanName.toLowerCase()) : ((String)e.getKey()).equalsIgnoreCase(beanName);
        }).map(Map.Entry::getValue).collect(HashSet::new, HashSet::add, AbstractCollection::addAll);
    }

    public static String getMessage(String key) {
        return context.getMessage(key, (Object[])null, Locale.getDefault());
    }

    public static Environment getEnvironment() {
        return context.getEnvironment();
    }

    public static String getActiveProfile() {
        return context.getEnvironment().getProperty("spring.profiles.active");
    }

    public static Boolean isProdEnvironment() {
        return "prod".equals(getActiveProfile());
    }

    public static Boolean isProdEnvironment(String environCode) {
        return StringUtils.isEmpty(environCode) ? false : environCode.equals(getActiveProfile());
    }
}
