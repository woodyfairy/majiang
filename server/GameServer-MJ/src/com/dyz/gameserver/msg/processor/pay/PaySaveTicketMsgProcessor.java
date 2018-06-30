package com.dyz.gameserver.msg.processor.pay;

import com.context.ErrorCode;
import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.ErrorResponse;
import com.dyz.myBatis.model.Payment;
import com.dyz.myBatis.services.PaymentService;
import com.dyz.persist.util.JsonUtilTool;

public class PaySaveTicketMsgProcessor extends MsgProcessor implements
INotAuthProcessor {
	public PaySaveTicketMsgProcessor(){

    }

    @Override
    public void process(GameSession gameSession, ClientRequest request) throws Exception {
        String message = request.getString();
        //System.out.println("mseeage: " + message);
        PaySaveTicketVO vo = (PaySaveTicketVO) JsonUtilTool.fromJson(message, PaySaveTicketVO.class);
        //System.out.println("order: " + vo.getOrder());
        if(gameSession.isLogin()) {
            Payment payment = PaymentService.getInstance().getPayment(vo.getOrder());
            if (payment != null)
            {
            	payment.setTicket(vo.getTicket());
            	PaymentService.getInstance().updatePayment(payment);
            }else{
            	System.out.println("未找到订单");
        		//gameSession.sendMsg(new StartPayOrderResponse(0, "未找到订单"));
        	}
        }else{
        	//system.out.println("未登录");
            gameSession.sendMsg(new ErrorResponse(ErrorCode.Error_000002));
        }
	}
}
