package com.dyz.gameserver.msg.processor.pay;

public class PaySaveTicketVO {
	private String order;
	public void setOrder(String order){
		this.order = order;
	}
	public String getOrder()
	{
		return order;
	}
	
	private String ticket;
	public void setTicket(String ticket){
		this.ticket = ticket;
	}
	public String getTicket()
	{
		return ticket;
	}
	
}
