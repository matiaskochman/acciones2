package com.prediccion.acciones2.ehcache;

import java.util.Iterator;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class TestEhCache {
    public static void main(String[] args) {
        CacheManager manager = new CacheManager("C:\\matias\\acciones2\\src\\main\\resources\\META-INF\\ehcache.xml");
        Cache newsCache = manager.getCache("newsCache");
        newsCache.put(new Element("2","Hello"));
        newsCache.put(new Element("3", "Bye"));
       displayElementInCache(newsCache);

        getElementFromCache(newsCache, "3");

        displayElementInCache(newsCache);
        getElementFromCache(newsCache, "4");
        displayElementInCache(newsCache);
        getElementFromCache(newsCache, "3");
        getElementFromCache(newsCache, "4");
        getElementFromCache(newsCache, "3");
    }

    private static void displayElementInCache(Cache newsCache) {
        System.out.println("Elements in the Cache");
        List<String> list = newsCache.getKeys();
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String key = itr.next();
            Element ele = newsCache.get(key);
            System.out.println(ele.getObjectKey() + " " + ele.getObjectValue());
        }
    }

    private static void getElementFromCache(Cache newsCache, String key) {
        Element element = newsCache.get(key);
        if (null != element) { // Cache Hit
            System.out.println("Cache Hit - " + element.getObjectValue());
        } else { // Cache Miss
            // Retreive from DB and add this to cache
            System.out.println("Cache Miss - Fetching from DB ...");
            newsCache.put(new Element(key,"default"));
        }
    }

}
