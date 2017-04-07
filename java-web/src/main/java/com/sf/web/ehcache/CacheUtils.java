package com.sf.web.ehcache;

import common.use.Person;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Created by SF on 2017/4/7.
 */
public class CacheUtils {
    private static CacheManager cacheManager;
    private static Cache cache;

    static {
        cacheManager = CacheManager.create(CacheUtils.class.getClassLoader().getResourceAsStream("ehcache.xml"));
        cache = cacheManager.getCache("myCache");
    }

    public static void put(String key, Object value) {
        Element element = new Element(key, value);
        cache.put(element);
        cache.flush();
    }

    public static <T> T get(String key, Class<T> typeClass) {
        Element element = cache.get(key);
        return element == null ? null : (T) element.getValue();
    }

    public static void main(String[] args) {
        Person jack = new Person().setName("jack").setAge(20);
        CacheUtils.put("jack", jack);
        System.out.println("put cache in");

        Person cacheJack = CacheUtils.get("jack", Person.class);
        System.out.println(cacheJack);

//        cacheManager.cacheExists("myCache");
//        cacheManager.shutdown();
    }
}
