package com.server.app;

import com.server.instances.FTPServer;
import com.server.instances.HTTPServer;
import com.server.instances.Server;
import com.server.request.ProtocolRequest;
import com.server.request.FTPRequest;
import com.server.request.HTTPRequest;
import com.server.validator.FTPUrlValidator;
import com.server.validator.HTTPUrlValidator;
import com.server.validator.UrlValidator;

public class Application {

    public static void requestCheck() {

        //request check
        String[] ftpHeaders = {"CompanyName:trendyolcom", "Filesize:10", "Mode:SYNC"};
        ProtocolRequest ftpRequest = new FTPRequest("FTP DATA!", ftpHeaders);
//        System.out.println(ftpRequest.prepareContext());

        String[] httpHeaders = {"CompanyName:trendyolcom", "ContextType:XML", "DataSize:10"};
        String[] queryParameters = {"department:Engineering", "page:1"};
        ProtocolRequest httpRequest = new HTTPRequest("HTTP DATA!", httpHeaders, queryParameters);
//        System.out.println(httpRequest.prepareContext());
//        HTTPRequest sınıfından bir nesne oluşturup bunu ProtocolRequest tipinde tutuyoruz polymorphizm

        // Server validation
        UrlValidator ftpUrlValidator = new FTPUrlValidator("ftp", ":21");
        Server ftpServer = new FTPServer(ftpUrlValidator);

        String ftpUrl = "ftp://abc.com:21/folder_name";
        boolean connection = ftpServer.connect(ftpUrl);

        if(connection) {
            System.out.println(ftpServer.prepareResponse(ftpRequest));
        }

        UrlValidator httpServerUrlValidator = new HTTPUrlValidator("http", ":80");
        Server httpServer = new HTTPServer(httpServerUrlValidator);

        String httpUrl = "http://www.google.com";
        connection = httpServer.connect(httpUrl);

        if(connection) {

            System.out.println(httpServer.prepareResponse(httpRequest));
        }
    }

    public static void validationCheck() {

        //validation check
        String ftpUrl = "ftp://abc.com:21/folder_name";
        UrlValidator ftpValidator = new FTPUrlValidator("ftp", ":21");
        boolean ftpValidationResult = ftpValidator.validate(ftpUrl);

        System.out.println("FTP Validation: " + ftpValidationResult);

        String httpUrl = "http://www.google.com";
        UrlValidator httpValidator = new HTTPUrlValidator("http", ":80");
        boolean httpValidationResult = httpValidator.validate(httpUrl);

        System.out.println("HTTP Validation: " + httpValidationResult);

    }

        public static void main(String[] args) {

        requestCheck();
//        validationCheck();

    }
}
