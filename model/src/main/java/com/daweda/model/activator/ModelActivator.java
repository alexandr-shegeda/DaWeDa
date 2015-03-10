package com.daweda.model.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Created by aleksandrsizov on 19.02.15.
 */
public class ModelActivator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Model bundle started");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Model bundle stopped");
    }
}
