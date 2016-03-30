package kws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceImpl implements Service {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);

    @Override
    public String compute(String base, long factor) {
        LOG.info("Compute for factor {}", factor);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < factor; ++i) {
            sb.append(base);
        }
        return sb.toString();
    }

}
