package com.jiabangou.bdwmsdk.model;

public class CmdSign extends Cmd {
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

}
