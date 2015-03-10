package com.daweda.services.lightstreamer;

import com.daweda.services.model.lightstreamer.Adapter;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdapterXMLParserTest
{
    @Test
    public void testGetAdapter() throws Exception
    {
        Adapter exp = new Adapter("MUTOPIA","10.47.2.129","8085");
        AdapterXMLParser act = new AdapterXMLParser();
        assertEquals(exp,act.getAdapter("MUTOPIA"));
    }
}