﻿using UnityEngine;
using System.Collections;
using cn.sharesdk.unity3d;
using AssemblyCSharp;
using System.IO;
using UnityEngine.UI;
using System;
using LitJson;

/**
 * 微信操作
 */ 
public class WechatOperateScript : MonoBehaviour {
	public ShareSDK shareSdk;
	private string picPath;
	//
	void Start () {
		if (shareSdk != null) {
            shareSdk.authHandler = AuthResultHandle;
			shareSdk.showUserHandler = getUserInforCallback;
			shareSdk.shareHandler = onShareCallBack;
		}

	}
	

	void Update () {
	
	}

    void AuthResultHandler(int reqID, ResponseState state, PlatformType type, Hashtable result)
    {
        if (state == ResponseState.Success)
        {
            print("authorize success !");
        }
        else if (state == ResponseState.Fail)
        {
            print("fail! error code = " + result["error_code"] + "; error msg = " + result["error_msg"]);
        }
        else if (state == ResponseState.Cancel)
        {
            print("cancel !");
        }
    }

	/**
	 * 登录，提供给button使用
	 * 
	 */ 
	public void login(){
        //TipsManagerScript.getInstance().setTips("获取个人信息成功");

        if(Application.platform == RuntimePlatform.Android)
        {
            shareSdk.Authorize(PlatformType.WeChat);
        }
        else{
            testLogin();
        }
	   
	}

    public void AuthResultHandle(int reqID, ResponseState state, PlatformType type, Hashtable data)
    {
        if(state == ResponseState.Success)
        {
            shareSdk.GetUserInfo(PlatformType.WeChat);
        }
        else if(state == ResponseState.Fail)
        {
            TipsManagerScript.getInstance().setTips("微信登录失败");
        }
    }

	/**
	 * 获取微信个人信息成功回调,登录
	 *
	 */ 
	public void getUserInforCallback(int reqID, ResponseState state, PlatformType type, Hashtable data){
		//TipsManagerScript.getInstance ().setTips ("获取个人信息成功");

		if (data != null) {
			MyDebug.Log (data.toJson ());
			LoginVo loginvo = new LoginVo ();
			try {

				loginvo.openId = (string)data ["openid"];
				loginvo.nickName = (string)data ["nickname"];
				loginvo.headIcon = (string)data ["headimgurl"];
				loginvo.unionid = (string)data ["unionid"];
				loginvo.province = (string)data ["province"];
				loginvo.city = (string)data ["city"];
				string sex = data ["sex"].ToString ();
				loginvo.sex = int.Parse (sex);
				loginvo.IP = GlobalDataScript.getInstance ().getIpAddress ();
				String msg = JsonMapper.ToJson (loginvo);

				CustomSocket.getInstance ().sendMsg (new LoginRequest (msg));

				GlobalDataScript.loginVo = loginvo;
				GlobalDataScript.loginResponseData = new AvatarVO ();
				GlobalDataScript.loginResponseData.account = new Account ();
				GlobalDataScript.loginResponseData.account.city = loginvo.city;
				GlobalDataScript.loginResponseData.account.openid = loginvo.openId;
				MyDebug.Log(" loginvo.nickName:"+loginvo.nickName);
				GlobalDataScript.loginResponseData.account.nickname = loginvo.nickName;
				GlobalDataScript.loginResponseData.account.headicon = loginvo.headIcon;
				GlobalDataScript.loginResponseData.account.unionid = loginvo.city;
				GlobalDataScript.loginResponseData.account.sex = loginvo.sex;
				GlobalDataScript.loginResponseData.IP = loginvo.IP;

			} catch (Exception e) {
				MyDebug.Log ("微信接口有变动！" + e.Message);
				//TipsManagerScript.getInstance ().setTips ("请先打开你的微信客户端");
                TipsManagerScript.getInstance().setTips(data.toJson());
				return;
			}
		} else {
			TipsManagerScript.getInstance ().setTips ("微信登录失败");
		}




	}


	/***
	 * 分享战绩成功回调
	 */ 
	public void onShareCallBack(int reqID,ResponseState state,PlatformType type,Hashtable result){
		if (state == ResponseState.Success) {
			TipsManagerScript.getInstance ().setTips ("分享成功");

		} else if(state == ResponseState.Fail){
			MyDebug.Log ("shar fail :" + result ["error_msg"]);
		}
	}

	/**
	 * 分享战绩、战绩
	 */ 
	public void shareAchievementToWeChat(PlatformType platformType){
		StartCoroutine(GetCapture(platformType));
	}

	/**
	 * 执行分享到朋友圈的操作
	 */ 
	private void shareAchievement(PlatformType platformType){
		ShareContent customizeShareParams = new ShareContent();
		customizeShareParams.SetText("");
		customizeShareParams.SetImagePath(picPath);
		customizeShareParams.SetShareType(ContentType.Image);
		customizeShareParams.SetObjectID("");
		customizeShareParams.SetShareContentCustomize(platformType, customizeShareParams);
		shareSdk.ShareContent (platformType, customizeShareParams);
	}

	/**
	 * 截屏
	 * 
	 * 
	 */ 
	private IEnumerator GetCapture(PlatformType platformType)
	{
		yield return new WaitForEndOfFrame();
		if(Application.platform==RuntimePlatform.Android || Application.platform==RuntimePlatform.IPhonePlayer)  

			picPath=Application.persistentDataPath;  

		else if(Application.platform==RuntimePlatform.WindowsPlayer)  

			picPath=Application.dataPath;  

		else if(Application.platform==RuntimePlatform.WindowsEditor)

		{  
			picPath=Application.dataPath;  
			picPath= picPath.Replace("/Assets",null);  
		}   

		picPath = picPath + "/screencapture.png";

		MyDebug.Log ("picPath:" + picPath);

		int width = Screen.width;
		int height = Screen.height;
		Texture2D tex = new Texture2D(width,height,TextureFormat.RGB24,false);
		tex.ReadPixels(new Rect(0,0,width,height),0,0,true);
		tex.Apply ();
		byte[] imagebytes = tex.EncodeToPNG();//转化为png图
		tex.Compress(false);//对屏幕缓存进行压缩
		MyDebug.Log("imagebytes:"+imagebytes);
		if (File.Exists (picPath)) {
			File.Delete (picPath);
		}
		File.WriteAllBytes(picPath,imagebytes);//存储png图
		Destroy(tex);
		shareAchievement(platformType);
	}

	// 分享接口
    public void ShareGames(PlatformType platformType)
    {
        ShareContent customizeShareParams = new ShareContent();
        customizeShareParams.SetText("给你发了一个29元大红包，快来领取你的红包!");
        customizeShareParams.SetUrl("http://gsqsjh.com/download");
        customizeShareParams.SetShareType(ContentType.Webpage);
        customizeShareParams.SetObjectID("");
	    customizeShareParams.SetImageUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527429848373&di=33c254c11436d40b23a2390ffe249845&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fzhidao%2Fwh%253D680%252C800%2Fsign%3D4cf11667fb1f3a295a9dddc8a1159009%2F8644ebf81a4c510f195c55a36b59252dd52aa5eb.jpg");
        customizeShareParams.SetShareContentCustomize(platformType, customizeShareParams);
        shareSdk.ShareContent(platformType, customizeShareParams);
    }


	public void inviteFriend(){
		if(GlobalDataScript.roomVo != null){
			RoomCreateVo roomvo = GlobalDataScript.roomVo;
			GlobalDataScript.totalTimes = roomvo.roundNumber;
			GlobalDataScript.surplusTimes = roomvo.roundNumber;
			string str="" ;

			if (roomvo.hong) {
				str += "红中麻将,";
			} else {
				if (roomvo.roomType == 1) {
					str += "转转麻将,";
				} else if (roomvo.roomType == 2){
					str += "划水麻将,";
				}else if (roomvo.roomType == 3){
					str += "长沙麻将,";
				}
			}

			str += "大战"+roomvo.roundNumber+"局,";
			if (roomvo.ziMo == 1) {
				str += "只能自摸,";
			} else {
				str += "可抢杠胡,";
			}
			if (roomvo.addWordCard) {
				str += "有风牌,";
			}

			if (roomvo.xiaYu > 0) {
				str += "下鱼"+roomvo.xiaYu+"条,";
			}

			if (roomvo.ma > 0) {
				str += "抓"+roomvo.ma+"个码,";
			}
			if (roomvo.magnification > 0) {
				str += "倍率"+roomvo.magnification;
			}
			str += "有胆，你就来！";

			string title = "微牌    "+ "房间号："+roomvo.roomId;
			ShareContent customizeShareParams = new ShareContent();
			customizeShareParams.SetTitle(title);
			customizeShareParams.SetText (str);
			customizeShareParams.SetUrl ("http://www.weipaigame.com/downLoad/index.html");
			customizeShareParams.SetImageUrl(APIS.ImgUrl+"icon96.png");
			customizeShareParams.SetShareType(ContentType.Webpage);
			customizeShareParams.SetObjectID("");
			shareSdk.ShowShareContentEditor(PlatformType.WeChat, customizeShareParams);
		}
	}


	private void testLogin(){
		CustomSocket.getInstance().sendMsg(new LoginRequest(null));
	}

}
