package com.dyz.gameserver.msg.processor.joinroom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.context.ErrorCode;
import com.dyz.gameserver.Avatar;
import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.logic.RoomLogic;
import com.dyz.gameserver.manager.GameSessionManager;
import com.dyz.gameserver.manager.RoomManager;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.ErrorResponse;
import com.dyz.gameserver.msg.response.joinroom.JoinRoomResponse;
import com.dyz.persist.util.GlobalUtil;
import com.dyz.gameserver.pojo.RoomVO;

import net.sf.json.JSONObject;

/**
 * 
 * @author luck
 * 加入房间
 */
public class JoinRoomMsgProcessor extends MsgProcessor implements
		INotAuthProcessor {
	
	public JoinRoomMsgProcessor() {
	}

	@Override
	public void process(GameSession gameSession, ClientRequest request)
			throws Exception {
		if(GlobalUtil.checkIsLogin(gameSession)) {
			JSONObject json = JSONObject.fromObject(request.getString());
			int roomId = (int)json.get("roomId");
			//if (avatar != null) {
				RoomLogic roomLogic = RoomManager.getInstance().getRoom(roomId);
				if (roomLogic != null) {
					Avatar avatar = gameSession.getRole(Avatar.class);
					if(avatar.avatarVO.getRoomId() != 0){
						//avatar.getSession().sendMsg(new ErrorResponse(ErrorCode.Error_000017));
						// 在房间则 直接回到房间
						//把session放入到GameSessionManager,并且移除以前的session
						GameSessionManager.getInstance().putGameSessionInHashMap(gameSession,avatar.getUuId());
						roomLogic.returnBackAction(avatar);
						return;
					}
					
					RoomVO roomVO = roomLogic.getRoomVO();
					if (roomVO.getIsAA()){
						int needCard = roomVO.getRoundNumber();
		            	if(roomVO.getRoundNumber() == 16){
		            		needCard = 12;
		            	}
		            	needCard = needCard/roomVO.getTotalPlayers();
		            	if(avatar.avatarVO.getAccount().getRoomcard() < needCard){
		            		//system.out.println("房间卡不足");
		                    gameSession.sendMsg(new ErrorResponse(ErrorCode.Error_000014));
		                    return;
		            	}
					}
					
					//roomLogic.intoRoom(avatar);
					boolean joinResult = roomLogic.intoRoom(avatar);
					if(joinResult) {
						logger.error("加入房间成功");
						// 如果此时房间人数满了，通知玩家进入游戏
						if(roomLogic.isRoomFull())
						{
							roomLogic.StartGame();
							logger.error("房间人满了，进入战场");
						}
					}else{
						logger.error("加入房间失败");
					}
				} else {
					gameSession.sendMsg(new ErrorResponse(ErrorCode.Error_000018));
				}
			//}
			//system.out.println("roomId --> " + roomId);
		}
		else{
			//system.out.println("该用户还没有登录");
			gameSession.destroyObj();
		}
	}

}
