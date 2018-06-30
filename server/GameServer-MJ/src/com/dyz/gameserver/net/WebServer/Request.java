package com.dyz.gameserver.net.WebServer;

import java.io.InputStream;
import com.alibaba.fastjson.JSONObject;

public class Request {
    private final static int BUFFER_SIZE = 1024;
    private InputStream input;
    private String uri;
    private JSONObject json;

    public Request(InputStream input) {
        this.input = input;
    }

    public void parse() {
        StringBuffer request = new StringBuffer();
        int readLength;
        byte[] buffer = new byte[BUFFER_SIZE];

        try {
            readLength = input.read(buffer);
        } catch (Exception e) {
            e.printStackTrace();
            readLength = -1;
        }
        for(int i = 0; i < readLength; i++) {
            request.append((char)buffer[i]);
        }
        //System.out.print(request.toString());
        uri = parseUri(request.toString());
        json = parseJson(request.toString());
        //System.out.print("json: " + json);
    }

    private String parseUri(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 > index1)
                return requestString.substring(index1 + 1, index2);
        }
        return null;
    }

    public String getUri() {
        return uri;
    }
    
    private JSONObject parseJson(String requestString){
    	int index1, index2;
        index1 = requestString.indexOf('{');
        if (index1 != -1) {
            index2 = requestString.indexOf('}', index1 + 1);
            if (index2 > index1)
            {
            	String jsonStr = requestString.substring(index1, index2 + 1);
            	JSONObject json = JSONObject.parseObject(jsonStr);
            	return json;
            }
        }
        return null;
    }
    public JSONObject getJson() {
        return json;
    }
}