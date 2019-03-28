package com.community.online.domain;

import java.util.Date;

public class Trade {
	private String id;
	private String content;	// goodId*name*price*num~goodId*name*price*num...
	private double totalPrice;
	private String place;
	private String payImg;
	private String userId;
	private String state;	// 0 未设置img 1 设置img
	private Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPayImg() {
		return payImg;
	}
	public void setPayImg(String payImg) {
		this.payImg = payImg;
	}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

    @Override
    public String toString() {
        return "Trade{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", totalPrice=" + totalPrice +
                ", place='" + place + '\'' +
                ", payImg='" + payImg + '\'' +
                ", userId='" + userId + '\'' +
                ", state='" + state + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
