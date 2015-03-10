package com.daweda.services.impl;

import com.daweda.services.SettlementProcessing;
import org.apache.felix.scr.annotations.Service;
import org.apache.log4j.Logger;

/**
 * Created by elena on 27.02.15.
 */
@Service
public class SettlementProcessingImpl implements SettlementProcessing {

    static final Logger LOG = Logger.getLogger(SettlementProcessingImpl.class);

    @Override
    public void run() {
        LOG.info("Executed settlement thread");
    }

}
