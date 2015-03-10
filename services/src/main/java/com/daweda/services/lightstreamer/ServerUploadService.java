package com.daweda.services.lightstreamer;

import com.daweda.services.model.lightstreamer.Adapter;
import com.lightstreamer.ls_client.PushConnException;
import com.lightstreamer.ls_client.PushServerException;
import com.lightstreamer.ls_client.PushUserException;

import java.util.Map;

/**
 * Created by Alexandr_Shegeda on 25.02.2015.
 */
public interface ServerUploadService {

    public void sendMessage(Map<String,String> map);
}
