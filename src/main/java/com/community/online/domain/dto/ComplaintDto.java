package com.community.online.domain.dto;

import java.util.Date;

public class ComplaintDto {
    private String id;
    private String realName;
    private String userId;
    private String content;
    private String img;
    private String parentId;
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ComplaintDto{" +
                "id='" + id + '\'' +
                ", realName='" + realName + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", img='" + img + '\'' +
                ", parentId='" + parentId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
