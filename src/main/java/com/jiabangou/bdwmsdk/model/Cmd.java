package com.jiabangou.bdwmsdk.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;

public class Cmd implements Serializable {
    protected String cmd;
    protected int timestamp;
    protected String version;
    protected String ticket;
    protected String source;
    protected String sign;
    protected Object body;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Cmd{" +
                "cmd='" + cmd + '\'' +
                ", timestamp=" + timestamp +
                ", version='" + version + '\'' +
                ", ticket='" + ticket + '\'' +
                ", source='" + source + '\'' +
                ", sign='" + sign + '\'' +
                ", body=" + body +
                '}';
    }
}
