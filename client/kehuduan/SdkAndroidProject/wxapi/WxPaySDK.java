package com.gsqsjh.qsmj.wxapi;

import android.os.Debug;
import android.util.Log;

import com.mob.paysdk.MobPayAPI;
import com.mob.paysdk.OnPayListener;
import com.mob.paysdk.PayOrder;
import com.mob.paysdk.PayResult;
import com.mob.paysdk.PaySDK;
import com.mob.paysdk.WXPayAPI;
import com.unity3d.player.UnityPlayer;

/**
 * Created by wudongyang on 2018/6/26.
 */

public class WxPaySDK {
    public  static void pay(String goodId, int num, int price){
        PayOrder order = new PayOrder();
        order.setOrderNo(goodId);//必须为数字
        order.setAmount(price);
        order.setSubject("支付");
        order.setBody("购买房卡：" + num);

        WXPayAPI wxPayAPI = PaySDK.createMobPayAPI(WXPayAPI.class);

        wxPayAPI.pay(order, new OnPayListener<PayOrder>() {
            @Override
            public boolean onWillPay(String ticketId, PayOrder order, MobPayAPI api) {
                // TODO 保存本次支付操作的 ticketId
                // 返回false表示不阻止本次支付
                Log.v("onWillPay", "ticketId: " + ticketId);
                UnityPlayer.UnitySendMessage("PaySdk","onWillPay", order.getOrderNo() + "," + ticketId);
                return false;
            }

            @Override
            public void onPayEnd(PayResult payResult, PayOrder order, MobPayAPI api) {
                // TODO 处理支付的结果，成功或失败可以在payResult中获取
                Log.v("onPayEnd", "payResult: " + payResult);
                if (payResult.getPayCode() == PayResult.PAYCODE_OK){
                    UnityPlayer.UnitySendMessage("PaySdk","onPaySuccess", order.getOrderNo());
                }else{
                    UnityPlayer.UnitySendMessage("PaySdk","onPayFail", order.getOrderNo());
                }
            }
        });
    }
}
