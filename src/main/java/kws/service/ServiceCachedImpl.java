package kws.service;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class ServiceCachedImpl implements Service {

    private Service service;
    private Cache cache;

    public ServiceCachedImpl(CacheManager cacheManager, Service service) {
        this.cache = cacheManager.getCache("x-data");
        this.service = service;
    }

    @Override
    public String compute(String base, long factor) {
        String cacheKey = base + String.valueOf(factor);

        Element res = cache.get(cacheKey);
        if (null != res) {
            return (String) res.getObjectValue();
        }

        String data = service.compute(base, factor);
        cache.put(new Element(cacheKey, data));
        return data;
    }

}
