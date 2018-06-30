using System.Collections;
using System.Collections.Generic;
using UnityEngine;
#if UNITY_IOS
using UnityEngine.iOS;
#endif

public enum Platform
{
    Editor,
    IOS,
    Android,
}


public class SdkManager : MonoBehaviour {
    

#if UNITY_EDITOR
    public static Platform platform = Platform.Editor;
#elif UNITY_ANDROID
    public static Platform platform = Platform.Android;
#elif UNITY_IOS
    public static Platform platform = Platform.IOS;
#endif

    static public SdkManager Instance = null;
    private SdkBase sdkApi = null;
    void Awake()
    {
        DontDestroyOnLoad(gameObject);
        Instance = this;
#if UNITY_EDITOR
        sdkApi = new SdkBase();
#elif UNITY_ANDROID
        sdkApi = new SdkAndroid();
#elif UNITY_IOS
		sdkApi = new SdkBase();
        //sdkApi = new SdkIOS();
        //sdkApi.sdkIapInit();
#endif
    }

	public void pay(string iapID, int num, int price)
    {
		sdkApi.sdkPay(iapID, num, price);
    }
    public void restore()
    {
        sdkApi.sdkRestore();
    }


	//微信支付回调
	public void onWillPay(string str)
	{
		if (ShopPanelScript.instance) {
			ShopPanelScript.instance.onWillPay (str);
		}
	}

	public void onPaySuccess(string order)
	{
		if (ShopPanelScript.instance) {
			ShopPanelScript.instance.onPaySuccess (order);
		}
	}

	public void onPayFail(string order)
	{
		if (ShopPanelScript.instance) {
			ShopPanelScript.instance.onPayFail (order);
		}
	}

}
