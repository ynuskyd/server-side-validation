package com.server.request;

public class FTPRequest extends ProtocolRequest{

    public FTPRequest(String data, String[] headers) {
        super(data, headers);
    }

//    her alt sınıf bu fonksiyonu kendine göre doldurdu.
    @Override
    public String prepareContext() {

        StringBuilder builder = new StringBuilder();
        builder.append("<FTP>");

        builder = prepareDataContext(builder);
        builder = prepareHeaderContext(builder);

        builder.append("</FTP>");

        return builder.toString();
    }

    private StringBuilder prepareDataContext(StringBuilder builder) {

        builder.append("<FDATA>\n");
        builder.append(super.getData());
        builder.append("</FDATA>\n");

        return builder;
    }

    private StringBuilder prepareHeaderContext(StringBuilder builder) {

        builder.append("<FHEADER>");

        for(String header: super.getHeaders()) {
            builder.append("<FHEADER>\n");
            builder.append(header);
            builder.append("</FHEADER>\n");
        }

        builder.append("</FHEADER>");

        return builder;
    }
}
