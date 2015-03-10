package com.daweda.services;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

/**
 * Created by iMAC on 04.03.15.
 */
@Component(immediate = true, metatype = false)
@Service(TestService.class)
public class TestServiceImpl implements TestService {
    @Override
    public String getString() {
        return "String";
    }
}
