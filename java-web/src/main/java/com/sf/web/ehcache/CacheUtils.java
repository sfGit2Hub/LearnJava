package com.sf.web.ehcache;

import common.use.Person;
import common.use.Sex;
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
        System.setProperty(net.sf.ehcache.CacheManager.ENABLE_SHUTDOWN_HOOK_PROPERTY, "true");
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
//        Person jack = new Person().setName("jack").setAge(20);
//        Person rose = new Person().setName("rose").setAge(20).setSex(Sex.FEMALE);
//        CacheUtils.put("jack", jack);
//        CacheUtils.put("rose", rose);
//        System.out.println("put cache in");

        Person cacheJack = CacheUtils.get("jack", Person.class);
        System.out.println(cacheJack);

        cacheManager.cacheExists("myCache");
        cacheManager.shutdown();
    }
}
