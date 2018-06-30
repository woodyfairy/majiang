package com.dyz.gameserver.net.WebServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.alibaba.fastjson.JSONObject;
import com.dyz.myBatis.model.Account;
import com.dyz.myBatis.model.Payment;
import com.dyz.myBatis.services.AccountService;
import com.dyz.myBatis.services.PaymentService;

public class Response {
    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream output;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException{
        byte[] buffer = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
        	boolean success = false;
        	JSONObject json = request.getJson();
        	if (json != null){
        		if (json.getInteger("result") == 2){
        			String order = json.getString("order_id");
        			int price = json.getIntValue("amount");
        			Payment payment = PaymentService.getInstance().getPayment(order);
        			if (payment != null && payment.getFinished() == false && payment.getPrice() == price){
        				int uid = payment.getUid();
        				int num = payment.getNum();
        				Account account = AccountService.getInstance().selectByUUid(uid);
        				account.setRoomcard(account.getRoomcard() + num);
        				payment.setFinished(true);
        				if (PaymentService.getInstance().updatePayment(payment) > 0){
        					if (AccountService.getInstance().updateByPrimaryKeySelective(account) > 0){
            					success = true;
            					output.write("HTTP/1.1 200 OK\n".getBytes());
                                output.write("Content-Type: text/html; charset=UTF-8\n\n".getBytes());
            				}
        				}
        			}
        		}
        	}
        	if (success == false){
        		String errMsg = "HTTP/1.1 404 File Not Found\r\n" + "Content-Type: text/html\r\n"
                        + "Content-Length: 23\r\n" + "\r\n" + "<h1>Fail</h1>";
                output.write(errMsg.getBytes());
        	}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(fis != null) {
                fis.close();
            }
        }
    }
}