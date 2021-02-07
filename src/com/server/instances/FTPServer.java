package com.server.instances;

import com.server.request.ProtocolRequest;
import com.server.validator.UrlValidator;

public class FTPServer extends Server{
    public FTPServer(UrlValidator urlValidator) {
        super(urlValidator);
    }

    @Override
    public boolean connect(String url) {
        return super.validateUrl(url);
    }

    @Override
    public String prepareResponse(ProtocolRequest request) {

        String requestContext = request.prepareContext();

        if(!requestContext.startsWith("<FTP>")) {
            return null;
        }

        if(!requestContext.startsWith("trendyolcom")) {
            return null;
        }
        String prefix = "<FDATA";
        int beginIndex = requestContext.indexOf(prefix) + prefix.length();
        int endIndex = requestContext.indexOf("/FDATA");

        String data = requestContext.substring(beginIndex, endIndex);

        return "Process FTP Data" + data;

    }
}
