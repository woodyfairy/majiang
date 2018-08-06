﻿using System;

namespace AssemblyCSharp
{
	public class APIS
	{
		public APIS ()
		{
		}
		//public const string UPDATE_INFO_JSON_URL = "http://192.168.0.110:8080/MaJiangManage/images/update.xml";//服务器上最新的软件版本信息存储文件
		//public const string UPDATE_INFO_JSON_URL = "http://www.weipaigame.com/downLoad/appDown/update.xml";//服务器上最新的软件版本信息存储文件
        public const string UPDATE_INFO_JSON_URL = "http://localhost:8080/download/update.xml";

        //////////public const string chatSocketUrl = "39.108.136.192";
		//public const string chatSocketUrl = "192.168.1.105";
        public const string chatSocketUrl = "39.104.112.20";

		//////////public const string socketUrl = "118.178.20.36";
		//////////public const string socketUrl = "39.108.136.192";
       	//public const string socketUrl = "192.168.1.105";
        public const string socketUrl = "39.104.112.20";

		public const string PIC_PATH = "http://www.weipagame.com:8080/";
	//	public const string apkDownLoadurl="192.168.0.111/aaa/weipai.apk";
		public const string ImgUrl = "http://118.178.20.13:9096/weiPaiImage/";
		public const int head = 0x000030;
		public const int headRESPONSE = 0x000031;

		//游戏关闭返回
		public const int CLOSE_RESPONSE = 0x000000;
        public const int LOGIN_REQUEST = 0x000001; //登陆请求码
		public const int LOGIN_RESPONSE = 0x000002;//登陆返回码

        public const int JOIN_ROOM_REQUEST = 0x000003;//加入房间请求码
        public const int JOIN_ROOM_RESPONSE = 0x000004;//加入房间返回码
		public const int JOIN_ROOM_NOICE = 0x10a004;//其它 人加入房间通知

        public const int START_PREPARE_GAME_REQUEST = 0X00007; // 请求进入游戏
        public const int START_PREPARE_GAME_RESPONSE = 0X00008; // 房间人满，准备开始游戏
        public const int CREATEROOM_REQUEST = 0x00009;//创建房间请求码
        public const int CREATEROOM_RESPONSE = 0x00010;//创建房间返回吗

		public const int STARTGAME_RESPONSE_NOTICE = 0x00012;//开始游戏
		public const int PICKCARD_RESPONSE = 0x100004;//自己摸牌 
		public const int OTHER_PICKCARD_RESPONSE_NOTICE = 0x100014;//别人摸牌通知

		public const int RETURN_INFO_RESPONSE =  0x100000;
		public const int CHUPAI_REQUEST = 0x100001;//出牌请求
		public const int CHUPAI_RESPONSE = 0x100002;//出牌通知

        public const int PENGPAI_REQUEST = 0x100005;//碰牌请求
        public const int PENGPAI_RESPONSE = 0x100006;//碰牌通知
        public const int GANGPAI_REQUEST = 0x100007;//杠牌请求
        public const int GANGPAI_RESPONSE = 0x100008;//杠牌返回
	    public const int OTHER_GANGPAI_NOICE = 0x10a008;//杠牌通知
        public const int HUPAI_REQUEST = 0x100009;//胡牌请求
        public const int HUPAI_RESPONSE = 0x100010;//胡牌通知
		public const int HUPAIALL_RESPONSE = 0x100110;//全局结束通知
        public const int GAVEUP_REQUEST = 0x100015;//放弃（胡，杠，碰，吃）

        public const int TINGPAI_REQUEST = 0x100017;//听牌请求
        public const int TINGPAI_RESPONE = 0x100018;//听牌通知

		public const int BACK_LOGIN_REQUEST = 0x001001;//掉线后重新登录查询当前牌桌情况请求
		public const int BACK_LOGIN_RESPONSE= 0x001002;//掉线后重新登录查询当前牌桌情况返回

		public const int OUT_ROOM_REQUEST = 0x000013;//退出房间请求
		public const int OUT_ROOM_RESPONSE =0x000014;//退出房间返回数7

		public const int DISSOLIVE_ROOM_REQUEST = 0X000113;//申请解散房间
		public const int DISSOLIVE_ROOM_RESPONSE = 0X000114;//解散房间回调

		public const int  PrepareGame_MSG_REQUEST = 0x333333;//
		public const int  PrepareGame_MSG_RESPONSE = 0x444444;//

		public const int ERROR_RESPONSE = 0xffff09;//错误回调

		public const int MicInput_Request = 200;
		public const int MicInput_Response = 201;

		public const int LoginChat_Request = 202;

		public const int MessageBox_Request = 203;
		public const int MessageBox_Notice = 204;

		public const int QUITE_LOGIN=0x555555;//退出登录调用，仅限于正常登录
		public const int CARD_CHANGE=0x777777;

		//public const int OUT_ROOM_RESPONSE = 0x001002;//离线通知
		public const int OFFLINE_NOTICE = 0x000015;
	    public const int ONLINE_NOTICE = 0x001111;

        public const int PRIZE_RESPONSE = 0x999999;//抽奖接口
		public const int GET_PRIZE=0x888888;//抽奖请求接口

		public const int RETURN_ONLINE_RESPONSE = 0x001003;//断线重连返回最后一次打牌数据
		public const int REQUEST_CURRENT_DATA = 0x001004;//申请最后打牌数据数据

	    public const int Game_FollowBander_Notice = 0x100016;//跟庄


		public const int GAME_BROADCAST = 0x157777;//游戏公告
		public const int CONTACT_INFO_REQUEST= 0x156666;//添加房卡请求数据
		public const int CONTACT_INFO_RESPONSE = 0x155555;//添加房卡返回数据
		public const int HOST_UPDATEDRAW_RESPONSE = 0x010111;//抽奖信息变化
		public const int ZHANJI_REPOTER_REQUEST = 0x002001;//战绩请求
		public const int ZHANJI_REPORTER_REPONSE=0x002002;//房间战绩返回数据
		public const int ZHANJI_DETAIL_REPORTER_REPONSE=0x002003;//某个房间详细每局战绩
		public const int ZHANJI_SEARCH_REQUEST= 0x002004;//搜索房间对应战绩

		public const int GAME_BACK_PLAY_REQUEST=0x003001;//回放请求
		public const int GAME_BACK_PLAY_RESPONSE = 0x003002;//回放返回数据
		public const int TIP_MESSAGE = 0x160016;

        //绑定邀请
        public const int INVITE_REQUEST = 0x004001;
        public const int INVITE_RESPONSE = 0X004002;
        public const int INVITE_GET_REWARD_REQUEST = 0x004003;
        public const int INVITE_GET_REWARD_RESPONSE = 0x004004;
        public const int INVITE_HISTORY_REQUEST = 0x004005;
        public const int INVITE_HISTORY_RESPONSE = 0x004006;

		public const int OTHER_TELE_LOGIN = 0x211211;//其他设备登录

		//支付相关
		public const int PAY_START_ORDER_REQUEST = 0x200001; //开始请求订单
		public const int PAY_START_ORDER_RESPONSE = 0x200002; //请求订单返回
		public const int PAY_SAVE_TICKET_REQUEST = 0x200003; //保存ticket
		public const int PAY_SUCCESS_REQUEST = 0x200004; //支付成功请求验证
		public const int PAY_SUCCESS_RESPONSE = 0x200005; //支付成功回调
	}



}

