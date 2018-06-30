using System;
using LitJson;
using System.Collections.Generic;
using UnityEngine;

namespace AssemblyCSharp
{
	public class StartPayOrderRequest:ClientRequest
	{
		
		public StartPayOrderRequest (int num)
		{
			headCode = APIS.PAY_START_ORDER_REQUEST;
			messageContent = num.ToString();
		}
	}

	public class SaveTicketRequest:ClientRequest
	{

		public SaveTicketRequest (string order, string ticket)
		{
			headCode = APIS.PAY_SAVE_TICKET_REQUEST;
			Dictionary<string, string> data = new Dictionary<string, string> ();
			data ["order"] = order;
			data ["ticket"] = ticket;
			string jsongStr = JsonMapper.ToJson (data);
			messageContent = jsongStr;
		}
	}

	public class PaySuccessRequest:ClientRequest
	{

		public PaySuccessRequest (string order)
		{
			headCode = APIS.PAY_SUCCESS_REQUEST;
			messageContent = order;
		}
	}
}

