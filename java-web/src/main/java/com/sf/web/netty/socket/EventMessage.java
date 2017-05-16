package com.sf.web.netty.socket;

/**
 * Created by SF on 2017/5/16.
 */
public class EventMessage {
    private String userId;
    private String message;

    public String getMessage() {
        return message;
    }

    public EventMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public EventMessage setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
