package com.server.validator;

public abstract class UrlValidator {

    protected String protocolPrefix;
    protected String portNo;

    public UrlValidator(String protocolPrefix, String portNo) {
        this.protocolPrefix = protocolPrefix;
        this.portNo = portNo;
    }

    public String getProtocolPrefix() {
        return protocolPrefix;
    }

    public String getPortNo() {
        return portNo;
    }

    public abstract boolean validate(String url);
}
