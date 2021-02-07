package com.server.validator;

public class FTPUrlValidator extends UrlValidator {

    public FTPUrlValidator(String protocolPrefix, String portNo) {
        super(protocolPrefix, portNo);
    }

    @Override
    public boolean validate(String url) {

        if(url == null) {

            return false;
        }

       boolean prefixCheck = url.startsWith(super.getProtocolPrefix());
       boolean portNumberCheck = url.contains(super.getPortNo());

        return prefixCheck && portNumberCheck;
    }
}
