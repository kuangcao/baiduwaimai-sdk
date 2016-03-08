package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

public class Cmd implements Serializable {
    protected String cmd;
    protected int timestamp;
    protected int version;
    protected String ticket;
    protected int source;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cmd cmd1 = (Cmd) o;

        if (timestamp != cmd1.timestamp) return false;
        if (version != cmd1.version) return false;
        if (source != cmd1.source) return false;
        if (cmd != null ? !cmd.equals(cmd1.cmd) : cmd1.cmd != null) return false;
        if (ticket != null ? !ticket.equals(cmd1.ticket) : cmd1.ticket != null) return false;
        if (sign != null ? !sign.equals(cmd1.sign) : cmd1.sign != null) return false;
        return body != null ? body.equals(cmd1.body) : cmd1.body == null;

    }

    @Override
    public int hashCode() {
        int result = cmd != null ? cmd.hashCode() : 0;
        result = 31 * result + timestamp;
        result = 31 * result + version;
        result = 31 * result + (ticket != null ? ticket.hashCode() : 0);
        result = 31 * result + source;
        result = 31 * result + (sign != null ? sign.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cmd{" +
                "cmd='" + cmd + '\'' +
                ", timestamp=" + timestamp +
                ", version=" + version +
                ", ticket='" + ticket + '\'' +
                ", source=" + source +
                ", sign='" + sign + '\'' +
                ", body=" + body +
                '}';
    }
}
