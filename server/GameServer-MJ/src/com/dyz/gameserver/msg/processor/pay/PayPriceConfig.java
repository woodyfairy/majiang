package com.dyz.gameserver.msg.processor.pay;

public class PayPriceConfig {
	//返回价格，单位：分
	public static int getPrice(int num){
//		if(num == 1){
//			return 1;
//		}else if (num <= 10){
//			return num * 200;
//		}else if (num <= 20){
//			return num * 175;
//		}else if (num <= 25){
//			return 4200;
//		}else if (num <= 36){
//			return 5800;
//		}else if (num <= 62){
//			return 9800;
//		}else if (num <= 130){
//			return 20000;
//		}else{
//			return num * 150;
//		}
		if(num == 16){
			return 800;
		}else if (num == 40){
			return 1800;
		}else if (num == 145){
			return 5800;
		}else if (num == 255){
			return 9800;
		}else if (num == 500){
			return 18800;
		}else if (num == 880){
			return 30800;
		}else{
			return num * 50;
		}
	}
}
