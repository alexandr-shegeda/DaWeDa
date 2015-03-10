package com.daweda.services.lightstreamer.Impl;

import com.daweda.services.lightstreamer.ServerUploadService;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ServerUploadServiceImplTest {

    Map<String,String> map;

    ServerUploadService upload;

    @Test
    public void testSendMessage_withMultiUploadInstance() throws Exception
    {
        SimpleDateFormat date = new SimpleDateFormat("hh:mm");

        map = new HashMap<>();
        map.put("description","some description");
        map.put("sTime", date.format(new Date()) );
        map.put("eTime", date.format(DateUtils.addMinutes(new Date(), 15)));
        map.put("minPrice","113.8");
        map.put("maxPrice","114.2");

        upload = new ServerUploadServiceImpl("DAWEDA", map);
    }

    @Test
    public void testSendMessage_withSingleUploadInstance() throws Exception
    {
        SimpleDateFormat date = new SimpleDateFormat("hh:mm");

        upload = new ServerUploadServiceImpl("DAWEDA");

        map = new HashMap<>();
        map.put("description","description");
        map.put("sTime", date.format(new Date()) );
        map.put("eTime", date.format(DateUtils.addMinutes(new Date(), 15)));
        map.put("minPrice","114");
        map.put("maxPrice","114.5");

        upload.sendMessage(map);

        map = new HashMap<>();
        map.put("description","some description");
        map.put("sTime", date.format(DateUtils.addMinutes(new Date(), 5)));
        map.put("eTime", date.format(DateUtils.addMinutes(new Date(), 20)));
        map.put("minPrice","113.5");
        map.put("maxPrice","114");

        upload.sendMessage(map);
    }
}