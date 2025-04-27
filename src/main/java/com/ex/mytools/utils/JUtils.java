package com.ex.mytools.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhengbingyuan
 * &#064;date 2025/4/17 14:56
 */
public class JUtils {
    /**
     * *********************************************************************************
     * 以下是流相关内容
     * *********************************************************************************
     */
    /**
     * 整理成map集合
     */
    public <T,K> Map<K,T> streamToMap(List<T> list, Function<? super T, ? extends K> keyMapper){
        if(list==null||list.isEmpty()){
            return new HashMap<>();
        }
        return list.stream().collect(Collectors.toMap(keyMapper, Function.identity(),(v1,v2)->v1));
    }

}
