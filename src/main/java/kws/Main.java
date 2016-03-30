package kws;

import kws.service.ServiceCachedImpl;
import kws.service.ServiceImpl;
import net.sf.ehcache.CacheManager;



public class Main {

    static final String BASE = "azertyuiopqsdfghjklmwxcvbnb";

    public static void main(String[] args) {
        System.out.println("START");

        ServiceImpl serviceImpl = new ServiceImpl();

        CacheManager cacheManager = CacheManager.create();
        ServiceCachedImpl serviceCachedImpl = new ServiceCachedImpl(cacheManager, serviceImpl);

        for (int i = 0; i < 20; ++i) {
            safeSleep(500);
            serviceCachedImpl.compute(BASE, i % 10 + 1);
        }

        cacheManager.shutdown();
        System.out.println("END");
    }

    private static void safeSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
        }
    }

}
