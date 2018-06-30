using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SdkAndroid : SdkBase {
    [NonSerialized]
	public static AndroidJavaClass androidSDK = new AndroidJavaClass("com.gsqsjh.qsmj.wxapi.WxPaySDK");

    public override void sdkIapInit()
    {
    }
	public override void sdkPay(string iapID, int num, int price)
    {
		androidSDK.CallStatic("pay", iapID, num, price);
    }
    public override void sdkFinishTransaction(string transArray)
    {
    }
    public override void sdkRestore()
    {
    }
    public override bool sdkWxInstalled()
    {
        return true;//默认打开
    }
}
