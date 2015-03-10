package com.daweda.services.email;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.URISyntaxException;

/**
 * Created by Alexandr_Shegeda on 27.02.2015.
 */
public class TemplateExtractor
{
    public String getTemplate(String template)
    {
        String res  = StringUtils.EMPTY;
        String line = StringUtils.EMPTY;
        try {
            File input = new File(this.getClass().getClassLoader().getResource(template).toURI());
            BufferedReader reader = new BufferedReader(new FileReader(input));
            while ((line=reader.readLine())!=null)
            {
                res+=line;
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
