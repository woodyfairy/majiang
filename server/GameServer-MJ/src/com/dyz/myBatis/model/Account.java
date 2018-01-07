package com.dyz.myBatis.model;

import java.util.Date;

public class Account {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.id
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.uuid
	 * @mbggenerated
	 */
	private Integer uuid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.openid
	 * @mbggenerated
	 */
	private String openid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.nickName
	 * @mbggenerated
	 */
	private String nickname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.headIcon
	 * @mbggenerated
	 */
	private String headicon;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.roomCard
	 * @mbggenerated
	 */
	private Integer roomcard;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.unionid
	 * @mbggenerated
	 */
	private String unionid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.province
	 * @mbggenerated
	 */
	private String province;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.city
	 * @mbggenerated
	 */
	private String city;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.sex
	 * @mbggenerated
	 */
	private Integer sex;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.prizecount
	 * @mbggenerated
	 */
	private Integer prizecount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.manager_up_id
	 * @mbggenerated
	 */
	private Integer managerUpId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.actualCard
	 * @mbggenerated
	 */
	private Integer actualcard;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.totalCard
	 * @mbggenerated
	 */
	private Integer totalcard;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.createTime
	 * @mbggenerated
	 */
	private Date createtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.lastLoginTime
	 * @mbggenerated
	 */
	private Date lastlogintime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.status
	 * @mbggenerated
	 */
	private String status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.isGame
	 * @mbggenerated
	 */
	private String isgame;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.invite
	 * @mbggenerated
	 */
	private Integer invite;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.inviteReward
	 * @mbggenerated
	 */
	private Integer invitereward;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.inviteGettedReward
	 * @mbggenerated
	 */
	private Integer invitegettedreward;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column account.playTimes
	 * @mbggenerated
	 */
	private Integer playtimes;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.id
	 * @return  the value of account.id
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.id
	 * @param id  the value for account.id
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.uuid
	 * @return  the value of account.uuid
	 * @mbggenerated
	 */
	public Integer getUuid() {
		return uuid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.uuid
	 * @param uuid  the value for account.uuid
	 * @mbggenerated
	 */
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.openid
	 * @return  the value of account.openid
	 * @mbggenerated
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.openid
	 * @param openid  the value for account.openid
	 * @mbggenerated
	 */
	public void setOpenid(String openid) {
		this.openid = openid == null ? null : openid.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.nickName
	 * @return  the value of account.nickName
	 * @mbggenerated
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.nickName
	 * @param nickname  the value for account.nickName
	 * @mbggenerated
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.headIcon
	 * @return  the value of account.headIcon
	 * @mbggenerated
	 */
	public String getHeadicon() {
		return headicon;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.headIcon
	 * @param headicon  the value for account.headIcon
	 * @mbggenerated
	 */
	public void setHeadicon(String headicon) {
		this.headicon = headicon == null ? null : headicon.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.roomCard
	 * @return  the value of account.roomCard
	 * @mbggenerated
	 */
	public Integer getRoomcard() {
		return roomcard;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.roomCard
	 * @param roomcard  the value for account.roomCard
	 * @mbggenerated
	 */
	public void setRoomcard(Integer roomcard) {
		this.roomcard = roomcard;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.unionid
	 * @return  the value of account.unionid
	 * @mbggenerated
	 */
	public String getUnionid() {
		return unionid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.unionid
	 * @param unionid  the value for account.unionid
	 * @mbggenerated
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid == null ? null : unionid.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.province
	 * @return  the value of account.province
	 * @mbggenerated
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.province
	 * @param province  the value for account.province
	 * @mbggenerated
	 */
	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.city
	 * @return  the value of account.city
	 * @mbggenerated
	 */
	public String getCity() {
		return city;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.city
	 * @param city  the value for account.city
	 * @mbggenerated
	 */
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.sex
	 * @return  the value of account.sex
	 * @mbggenerated
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.sex
	 * @param sex  the value for account.sex
	 * @mbggenerated
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.prizecount
	 * @return  the value of account.prizecount
	 * @mbggenerated
	 */
	public Integer getPrizecount() {
		return prizecount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.prizecount
	 * @param prizecount  the value for account.prizecount
	 * @mbggenerated
	 */
	public void setPrizecount(Integer prizecount) {
		this.prizecount = prizecount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.manager_up_id
	 * @return  the value of account.manager_up_id
	 * @mbggenerated
	 */
	public Integer getManagerUpId() {
		return managerUpId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.manager_up_id
	 * @param managerUpId  the value for account.manager_up_id
	 * @mbggenerated
	 */
	public void setManagerUpId(Integer managerUpId) {
		this.managerUpId = managerUpId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.actualCard
	 * @return  the value of account.actualCard
	 * @mbggenerated
	 */
	public Integer getActualcard() {
		return actualcard;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.actualCard
	 * @param actualcard  the value for account.actualCard
	 * @mbggenerated
	 */
	public void setActualcard(Integer actualcard) {
		this.actualcard = actualcard;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.totalCard
	 * @return  the value of account.totalCard
	 * @mbggenerated
	 */
	public Integer getTotalcard() {
		return totalcard;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.totalCard
	 * @param totalcard  the value for account.totalCard
	 * @mbggenerated
	 */
	public void setTotalcard(Integer totalcard) {
		this.totalcard = totalcard;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.createTime
	 * @return  the value of account.createTime
	 * @mbggenerated
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.createTime
	 * @param createtime  the value for account.createTime
	 * @mbggenerated
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.lastLoginTime
	 * @return  the value of account.lastLoginTime
	 * @mbggenerated
	 */
	public Date getLastlogintime() {
		return lastlogintime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.lastLoginTime
	 * @param lastlogintime  the value for account.lastLoginTime
	 * @mbggenerated
	 */
	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.status
	 * @return  the value of account.status
	 * @mbggenerated
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.status
	 * @param status  the value for account.status
	 * @mbggenerated
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.isGame
	 * @return  the value of account.isGame
	 * @mbggenerated
	 */
	public String getIsgame() {
		return isgame;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.isGame
	 * @param isgame  the value for account.isGame
	 * @mbggenerated
	 */
	public void setIsgame(String isgame) {
		this.isgame = isgame == null ? null : isgame.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.invite
	 * @return  the value of account.invite
	 * @mbggenerated
	 */
	public Integer getInvite() {
		return invite;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.invite
	 * @param invite  the value for account.invite
	 * @mbggenerated
	 */
	public void setInvite(Integer invite) {
		this.invite = invite;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.inviteReward
	 * @return  the value of account.inviteReward
	 * @mbggenerated
	 */
	public Integer getInvitereward() {
		return invitereward;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.inviteReward
	 * @param invitereward  the value for account.inviteReward
	 * @mbggenerated
	 */
	public void setInvitereward(Integer invitereward) {
		this.invitereward = invitereward;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.inviteGettedReward
	 * @return  the value of account.inviteGettedReward
	 * @mbggenerated
	 */
	public Integer getInvitegettedreward() {
		return invitegettedreward;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.inviteGettedReward
	 * @param invitegettedreward  the value for account.inviteGettedReward
	 * @mbggenerated
	 */
	public void setInvitegettedreward(Integer invitegettedreward) {
		this.invitegettedreward = invitegettedreward;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column account.playTimes
	 * @return  the value of account.playTimes
	 * @mbggenerated
	 */
	public Integer getPlaytimes() {
		return playtimes;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column account.playTimes
	 * @param playtimes  the value for account.playTimes
	 * @mbggenerated
	 */
	public void setPlaytimes(Integer playtimes) {
		this.playtimes = playtimes;
	}
}