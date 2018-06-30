package com.dyz.gameserver.msg.response.pay;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;

public class PaySuccessResponse  extends ServerResponse{
	/**
     * 必须调用此方法设置消息号
     *
     * @param
     */
    public PaySuccessResponse(int status,String obj) throws IOException {
        super(status,ConnectAPI.PAY_SUCCESS_RESPONSE);
        output.writeUTF(obj);
    	System.out.println("roomCard:"+obj);
    	output.close();
        if(status > 0){
        	System.out.println("roomCard:"+obj);
        }else{
        	System.out.println("PaySuccessResponse: fail");
        }
    }
}
