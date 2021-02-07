package com.server.instances;

import com.server.request.ProtocolRequest;
import com.server.validator.UrlValidator;

public class HTTPServer extends Server{
    public HTTPServer(UrlValidator urlValidator) {
        super(urlValidator);
    }

    @Override
    public boolean connect(String url) {
        return super.validateUrl(url);
    }

    @Override
    public String prepareResponse(ProtocolRequest request) {

        String requestContext = request.prepareContext();

        if(!requestContext.startsWith("<HTTP>")) {
            return null;
        }

        String prefix = "<DATA";
        int beginIndex = requestContext.indexOf(prefix) + prefix.length();
        int endIndex = requestContext.indexOf("/DATA");

        String data = requestContext.substring(beginIndex, endIndex);
        // iki değer asrasını bana ver
        return "Process HTTP Data" + data;
    }
}
