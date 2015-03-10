package com.daweda.webservices.rest;

import org.osgi.framework.BundleContext;

import javax.annotation.Resource;

/**
 * Created by aleksandrsizov on 24.02.15.
 */
public class AbstractService {

    @Resource
    protected BundleContext context;

//    protected<T> T getService(Class<T> clazz){
//        ServiceReference<T> sref = context.getServiceReference(clazz);
//        return context.getService(sref);
//    }

}
