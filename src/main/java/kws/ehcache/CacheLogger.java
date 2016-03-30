package kws.ehcache;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CacheLogger extends CacheEventListenerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(CacheLogger.class);


    @Override
    public void notifyElementRemoved(Ehcache cache, Element element) throws CacheException {
        LOG.info("REMOVED {}", element.getObjectKey());
    }

    @Override
    public void notifyElementPut(Ehcache cache, Element element) throws CacheException {
        LOG.info("PUT {}", element.getObjectKey());
    }


    @Override
    public void notifyElementExpired(Ehcache cache, Element element) {
        LOG.info("EXPIRED {}", element.getObjectKey());
    }

    @Override
    public void notifyElementEvicted(Ehcache cache, Element element) {
        LOG.info("EVICTED {}", element.getObjectKey());
    }

    @Override
    public void notifyRemoveAll(Ehcache cache) {
        LOG.info("REMOVED ALL");
    }


}
