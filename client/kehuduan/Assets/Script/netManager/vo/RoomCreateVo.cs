﻿using System;

namespace AssemblyCSharp
{
	[Serializable]
	public class RoomCreateVo
	{
        public int totalPlayers;
		public  bool hong;
		public int ma;
		public int roomId;
		public int roomType;//1、清水；2、划水；3、长沙
		/**局数**/
		public int roundNumber;
		public bool sevenDouble;
		public int ziMo;//1：自摸胡；2、抢杠胡
		public int xiaYu;
		public string name;
		public bool addWordCard;
		public int magnification;
        public bool shengyu20;
        public bool threefornext;
        public bool showTingPai;
        public int cardNumber;
        //支付
        public bool isAA;
		public RoomCreateVo()
		{

		}
	}
}

