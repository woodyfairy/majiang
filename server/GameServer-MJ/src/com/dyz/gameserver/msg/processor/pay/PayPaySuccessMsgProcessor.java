package com.dyz.gameserver.msg.processor.pay;

import com.context.ErrorCode;
import com.dyz.gameserver.Avatar;
import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.ErrorResponse;
import com.dyz.gameserver.msg.response.pay.PaySuccessResponse;
import com.dyz.myBatis.model.Payment;
import com.dyz.myBatis.services.PaymentService;
import com.dyz.persist.util.JsonUtilTool;

public class PayPaySuccessMsgProcessor extends MsgProcessor implements
		INotAuthProcessor {
	public PayPaySuccessMsgProcessor() {

	}

	@Override
	public void process(GameSession gameSession, ClientRequest request)
			throws Exception {
		String message = request.getString();
		// PaySaveTicketVO vo = (PaySaveTicketVO) JsonUtilTool.fromJson(message,
		// PaySaveTicketVO.class);
		String order = message;
		System.out.println("Order: " + order);
		if (gameSession.isLogin()) {
			Payment payment = PaymentService.getInstance().getPayment(order);
			if (payment != null) {
				if (payment.getFinished() == true) {
					Avatar avatar = gameSession.getRole(Avatar.class);
					gameSession.sendMsg(new PaySuccessResponse(1, avatar.avatarVO.getAccount().getRoomcard().toString()));
				} else {
					gameSession.sendMsg(new PaySuccessResponse(0, "订单未完成"));
				}
			} else {
				System.out.println("未找到订单");
				// gameSession.sendMsg(new StartPayOrderResponse(0, "未找到订单"));
			}
		} else {
			// system.out.println("未登录");
			gameSession.sendMsg(new ErrorResponse(ErrorCode.Error_000002));
		}
	}
}
