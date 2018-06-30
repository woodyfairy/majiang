//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.gsqsjh.qsmj.wxapi;

import android.content.Intent;
import android.widget.Toast;
import cn.sharesdk.wechat.utils.WXAppExtendObject;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import cn.sharesdk.wechat.utils.WechatHandlerActivity;

public class WXEntryActivity extends WechatHandlerActivity {
    public WXEntryActivity() {
    }

    public void onGetMessageFromWXReq(WXMediaMessage msg) {
        if(msg != null) {
            Intent iLaunchMyself = this.getPackageManager().getLaunchIntentForPackage(this.getPackageName());
            this.startActivity(iLaunchMyself);
        }

    }

    public void onShowMessageFromWXReq(WXMediaMessage msg) {
        if(msg != null && msg.mediaObject != null && msg.mediaObject instanceof WXAppExtendObject) {
            WXAppExtendObject obj = (WXAppExtendObject)msg.mediaObject;
            Toast.makeText(this, obj.extInfo, 0).show();
        }

    }
}
