package com.daweda.services.lightstreamer.Impl;

import com.daweda.services.exception.AdapterNotFoundException;
import com.daweda.services.lightstreamer.AdapterXMLParser;
import com.daweda.services.lightstreamer.ServerUploadService;
import com.daweda.services.model.lightstreamer.Adapter;

import com.daweda.services.model.lightstreamer.LSMessage;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import com.lightstreamer.ls_client.*;
import org.apache.log4j.Logger;
import java.util.Map;
/*
 * Created by Alexandr_Shegeda on 23.02.2015.
 */
@Service
@Component(immediate = true)
public class ServerUploadServiceImpl implements ServerUploadService
{
    private Adapter instance;
    private AdapterXMLParser parser;
    private LSClient myClient;

    static final Logger LOG = Logger.getLogger(ServerUploadServiceImpl.class.getName());

    public ServerUploadServiceImpl(String adapterName, Map<String,String> map)
    {
        this.parser = new AdapterXMLParser();
        try {
            this.instance = parser.getAdapter(adapterName);
            LOG.info("Adapter instance created: "+adapterName);
        } catch (AdapterNotFoundException e) {
            LOG.trace(e.getStackTrace());
        }
        this.myClient = init();
        sendMessage(map);
    }

    public ServerUploadServiceImpl(String adapterName)
    {
        this.parser = new AdapterXMLParser();
        try {
            this.instance = parser.getAdapter(adapterName);
            LOG.info("Adapter instance created: "+adapterName);
        } catch (AdapterNotFoundException e) {
            LOG.trace(e.getStackTrace());
        }
        this.myClient = init();
    }

    public LSClient init()
    {
        myClient = new LSClient();
        try {
            myClient.openConnection( getConnection() , getConnectionListener() );
        } catch (PushConnException e) {
            LOG.trace(e.getStackTrace());
        } catch (PushServerException e) {
            LOG.trace(e.getStackTrace());
        } catch (PushUserException e) {
            LOG.trace(e.getStackTrace());
        }
        return myClient;
    }

    private ConnectionInfo getConnection()
    {
        ConnectionInfo connection = new ConnectionInfo() {
            {
                this.pushServerUrl = "http://" + instance.getHost() + ":" + instance.getPort();
                this.adapter = instance.getAdapterName();
            }
        };
        return connection;
    }

    private ExtendedConnectionListener getConnectionListener()
    {
        ExtendedConnectionListener connectionListener = new ExtendedConnectionListener() {

            private long bytes = 0;

            public void onConnectionEstablished() {
                LOG.info("connection established");
            }

            public void onSessionStarted(boolean isPolling) {
                //never called
            }

            public void onSessionStarted(boolean isPolling, String controlLink) {
                String clAddendum = controlLink != null ? " to server " + controlLink : "";
                if (isPolling) {
                    LOG.info("Session started in smart polling" + clAddendum);
                } else {
                    LOG.info("Session started in streaming" + clAddendum);
                }
            }

            public void onNewBytes(long newBytes) {
                this.bytes += newBytes;
            }

            public void onDataError(PushServerException e) {
                LOG.info("data error");
                LOG.trace(e.getStackTrace());
            }

            public void onActivityWarning(boolean warningOn) {
                if (warningOn) {
                    LOG.info("connection stalled");
                } else {
                    LOG.warn("connection no longer stalled");
                }
            }

            public void onEnd(int cause) {
                LOG.info("connection forcibly closed with cause code " + cause);
            }

            public void onClose() {
                LOG.info("total bytes: " + bytes);
            }

            public void onFailure(PushServerException e) {
                LOG.warn("server failure");
                LOG.trace(e.getStackTrace());
            }

            public void onFailure(PushConnException e) {
                LOG.warn("connection failure");
                LOG.trace(e.getStackTrace());
            }
        };

        return connectionListener;
    }

    @Override
    public void sendMessage(Map<String,String> map)
    {
        LSMessage message = new LSMessage(map);
        try {
            myClient.sendMessage(message.toString());
            LOG.info("Message successful sent: "+message.toString());
        } catch (PushConnException e) {
            e.printStackTrace();
        } catch (PushServerException e) {
            e.printStackTrace();
        } catch (PushUserException e) {
            e.printStackTrace();
        }
    }
}


