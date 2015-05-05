package com.prediccion.acciones2.utils;

import net.sf.ehcache.CacheManager;


public class EHCacheUtils {
	
	private static final CacheManager cacheManager;
	private EHCacheUtils(){
		
	}
	static {
		String path = EHCacheUtils.class.getClassLoader().getResource("").getPath() + "ehcache.xml";
		cacheManager = CacheManager.newInstance(path);
	}
	public static CacheManager getCacheManager(){
		return cacheManager;
	}
}
