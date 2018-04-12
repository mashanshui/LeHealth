package com.shenhesoft.lehealth.adapter.bean;

/**
 * @author mashanshui
 * @date 2018/4/12
 * @desc TODO
 */
public class MessageItem {
    private Integer image;
    private String message;

    public MessageItem(Integer image, String message) {
        this.image = image;
        this.message = message;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
