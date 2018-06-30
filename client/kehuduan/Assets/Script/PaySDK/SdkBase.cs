using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SdkBase{

    public virtual void sdkIapInit()
    {

    }
	public virtual void sdkPay(string iapID, int num, int price)
    {

    }
    public virtual void sdkFinishTransaction(string transArray)
    {

    }
    public virtual void sdkRestore()
    {

    }

    public virtual bool sdkWxInstalled()
    {
        return false;
    }
}
