package com.community.online.domain;

import java.util.Date;

public class Complaint {
    private String id;
    private String content;
    private String parentId;
    private String userId;
    private String img;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", parentId='" + parentId + '\'' +
                ", userId='" + userId + '\'' +
                ", img='" + img + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
