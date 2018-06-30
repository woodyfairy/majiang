package com.dyz.gameserver.msg.processor.pay;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.context.ErrorCode;
import com.dyz.gameserver.Avatar;
import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
//import com.dyz.gameserver.manager.RoomManager;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.ErrorResponse;
//import com.dyz.gameserver.msg.response.createroom.CreateRoomResponse;
import com.dyz.gameserver.pojo.AvatarVO;
//import com.dyz.gameserver.msg.response.login.LoginResponse;
//import com.dyz.gameserver.pojo.RoomVO;
//import com.dyz.persist.util.JsonUtilTool;
import com.dyz.gameserver.msg.response.pay.*;
import com.dyz.myBatis.model.Payment;
import com.dyz.myBatis.services.PaymentService;
//import com.dyz.persist.util.TimeUitl;

/**
 * Created by kevin on 2016/6/21.
 */

public class PayStartOrderMsgProcessor extends MsgProcessor implements
        INotAuthProcessor {

    public PayStartOrderMsgProcessor(){

    }

    @Override
    public void process(GameSession gameSession, ClientRequest request) throws Exception {
        String message = request.getString();
        //RoomVO roomVO = (RoomVO) JsonUtilTool.fromJson(message, RoomVO.class);
        int num = Integer.parseInt(message);
        if(gameSession.isLogin()) {
            Avatar avatar = gameSession.getRole(Avatar.class);
            	
            	//创建订单写入数据库
            	AvatarVO avatarVo = avatar.avatarVO;
            	int uid = avatarVo.getAccount().getUuid();
            	String uidString = Integer.toString(uid);
            	Date date = new Date();
            	String orderIDStr = uidString.substring(uidString.length()-5, uidString.length());
            	for (int i = 0; i < 5; i ++){
            		orderIDStr += (int)(Math.random() * 99);
            	}
            	int price = PayPriceConfig.getPrice(num);
            	//orderID为uid后5位+10位随机数
            	Payment payment = new Payment();
            	payment.setOrdernum(orderIDStr);
            	payment.setUid(uid);
            	payment.setNum(num);
            	payment.setPrice(price);
            	payment.setDate(date);
            	payment.setFinished(false);
            	
            	if (PaymentService.getInstance().createOrder(payment) > 0){
            		JSONObject json  = new JSONObject();
            		json.put("orderNum", orderIDStr);
            		json.put("num", num);
            		json.put("price", price);
                	
                	gameSession.sendMsg(new StartPayOrderResponse(1, json.toString()));
            	}else{
            		gameSession.sendMsg(new StartPayOrderResponse(0, "创建订单失败"));
            	}
            }else{
            	//system.out.println("未登录");
                gameSession.sendMsg(new ErrorResponse(ErrorCode.Error_000002));
		}
	}
}
