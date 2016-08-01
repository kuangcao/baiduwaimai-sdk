package com.jiabangou.bdwmsdk.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;


@JSONType
public class CmdSign extends Cmd implements Serializable {
    private String secret;

    public CmdSign(Cmd cmd, String secret) {
        this.cmd = cmd.getCmd();
        this.version = cmd.getVersion();
        this.ticket = cmd.getTicket();
        this.body = cmd.getBody();
        this.source = cmd.getSource();
        this.timestamp = cmd.getTimestamp();
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CmdSign cmdSign = (CmdSign) o;

        return secret != null ? secret.equals(cmdSign.secret) : cmdSign.secret == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (secret != null ? secret.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CmdSign{" +
                "secret='" + secret + '\'' +
                '}';
    }
}
