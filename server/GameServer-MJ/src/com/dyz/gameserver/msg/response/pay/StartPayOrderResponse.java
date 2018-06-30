package com.dyz.gameserver.msg.response.pay;

import java.io.IOException;

import com.context.ConnectAPI;
import com.dyz.gameserver.commons.message.ServerResponse;

public class StartPayOrderResponse extends ServerResponse {
	/**
     * 必须调用此方法设置消息号
     *
     * @param
     */
    public StartPayOrderResponse(int status,String obj) throws IOException {
        super(status,ConnectAPI.PAY_START_ORDER_RESPONSE);
        output.writeUTF(obj);
    	//System.out.println("PayOrderNum:"+obj);
    	output.close();
    }
}
