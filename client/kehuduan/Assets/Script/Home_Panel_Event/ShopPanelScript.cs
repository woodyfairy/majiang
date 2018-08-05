using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using AssemblyCSharp;
using LitJson;

public class ShopPanelScript : MonoBehaviour {
	public static ShopPanelScript instance;
	GameObject waitingPanel;
	int retryTimes = 0;
	string checkingOrder;

    //代理号
    string daili = "JHWL-01";
    Text daliTitle = null;
    Button CopyWechat = null;

    // Use this for initialization
    void Start () {
		instance = this;
		SocketEventHandle.getInstance ().startPayOrderResponse += startPayOrderCallback;
		SocketEventHandle.getInstance ().paySuccessResponse += paySuccessCallback;

		waitingPanel = transform.Find ("Panel_wating").gameObject;

        daliTitle = transform.Find("head_decro").Find("headDescro").GetComponent<Text>();
        daliTitle.text = "游戏代理招募：" + daili;
        CopyWechat = transform.Find("head_decro").Find("CopyWechat").GetComponent<Button>();
        CopyWechat.onClick.AddListener(copyWechat);
    }
    void copyWechat()
    {
        TextEditor textEditor = new TextEditor();
        textEditor.text = daili;
        textEditor.OnFocus();
        textEditor.Copy();
    }
	private void removeListener(){
		instance = null;
		SocketEventHandle.getInstance ().startPayOrderResponse -= startPayOrderCallback;
		SocketEventHandle.getInstance ().paySuccessResponse -= paySuccessCallback;
	}
	
	// Update is called once per frame
	void Update () {
		
	}

    public void ClosePanel()
    {
		removeListener();
		this.transform.parent = null;
        Destroy(this);
        Destroy(gameObject);
    }

	public void pay(int num)
	{
		retryTimes = 0;
		waitingPanel.SetActive (true);
		CustomSocket.getInstance().sendMsg(new StartPayOrderRequest(num));

		//test
//		Dictionary<string, string> data = new Dictionary<string, string> ();
//		data ["1"] = "1";
//		data ["2"] = "2";
//		string jsongStr = JsonMapper.ToJson (data);
//		MyDebug.Log ("jsongStr: " + jsongStr);
//
//		JsonData Json = new JsonData ();
//		Json ["1"] = "1";
//		Json ["2"] = "2";
//		MyDebug.Log ("jsongStr: " + Json.ToString());
	}

	class ResOderObj : object
	{
		public string orderNum;
		public int num;
		public int price; //分
	}

	public void startPayOrderCallback(ClientResponse response)
	{
		waitingPanel.SetActive(false);
		if (response.status == 1) {
			Debug.LogError (response.message);
			ResOderObj order = JsonMapper.ToObject<ResOderObj> (response.message);
			//MyDebug.Log ("Order: " + order.orderNum);

			SdkManager.Instance.pay (order.orderNum, order.num, order.price);
		} else {
			//失败
			TipsManagerScript.getInstance ().setTips (response.message);
		}
	}

	//微信支付回调
	public void onWillPay(string str)
	{
		string[] sArray=str.Split(',');
		string order = sArray [0];
		string ticketId = sArray [1];
		CustomSocket.getInstance().sendMsg(new SaveTicketRequest(order, ticketId));
	}

	public void onPaySuccess(string order)
	{
		waitingPanel.SetActive (true);
		checkingOrder = order;
		CustomSocket.getInstance().sendMsg(new PaySuccessRequest(order));
	}

	public void onPayFail(string order)
	{
		//TipsManagerScript.getInstance ().setTips (order);
	}

	public void paySuccessCallback(ClientResponse response)
	{
		if (response.status == 1) {
			waitingPanel.SetActive(false);
			TipsManagerScript.getInstance ().setTips ("购买成功");
		} else {
			//失败
			if (retryTimes < 3) {
				StartCoroutine(retry());
			} else {
				waitingPanel.SetActive(false);
				TipsManagerScript.getInstance ().setTips (response.message);
			}

		}
	}
	IEnumerator retry()
	{
		yield return new WaitForSeconds(10.0f);
		CustomSocket.getInstance().sendMsg(new PaySuccessRequest(checkingOrder));
		retryTimes++;
	}
}
