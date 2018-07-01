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
        System.out.println(request.toString());
        uri = parseUri(request.toString());
        json = parseJson(request.toString());
        System.out.println("json: " + json);
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
//    	int index1, index2;
//        index1 = requestString.indexOf('{');
//        if (index1 != -1) {
//            index2 = requestString.indexOf('}', index1 + 1);
//            if (index2 > index1)
//            {
//            	String jsonStr = requestString.substring(index1, index2 + 1);
//            	JSONObject json = JSONObject.parseObject(jsonStr);
//            	return json;
//            }
//        }
//        return null;
    	JSONObject json = new JSONObject();
    	String[] arrKeys = new String[4];
    	arrKeys[0] = "sign";
    	arrKeys[1] = "result";
    	arrKeys[2] = "orderId";
    	arrKeys[3] = "amount";
    	for	(int i = 0; i < arrKeys.length; i ++){
    		String key = arrKeys[i];
    		int index = requestString.indexOf(key + "=");
        	if (index != -1){
        		String subString = requestString.substring(index + key.length() + 1, requestString.length());
        		int index2 = subString.indexOf('&');
        		if (index2 != -1){
        			String value = subString.substring(0, index2);
        			json.put(key, value);
        		}else{
        			json.put(key, subString);
        		}
        	}
    	}
    	
    	return json;
    }
    public JSONObject getJson() {
        return json;
    }
}