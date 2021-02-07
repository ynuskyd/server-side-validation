package com.server.request;

public class HTTPRequest extends ProtocolRequest{

    private String[] queryParameters;

    public HTTPRequest(String data) {
        super(data);
        this.queryParameters = new String[100];

    }

    public HTTPRequest(String data, String[] headers) {
        super(data, headers);
        this.queryParameters = new String[100];
    }
    public HTTPRequest(String data, String[] headers, String[] queryParameters) {
        super(data, headers);
        this.queryParameters = queryParameters;
    }


    public String[] getQueryParameters() {
        return queryParameters;
    }

    public void setQueryParameters(String[] queryParameters) {
        this.queryParameters = queryParameters;
    }

    public void addQueryParameters(String queryParam) {
        this.queryParameters[this.queryParameters.length - 1] = queryParam;
    }

//    bu soyut fonksiyonu alt sınıflarda kullanabilmek amacı ile abstract yaptık. kendimize göre dolduracaz.

    @Override
    public String prepareContext() {

//        daha performanslı olduğu için stringleri birleştiren stringbuilder kullanıyoruz.

        StringBuilder builder = new StringBuilder();
        builder.append("<HTTP>");

        builder = prepareDataContext(builder);
        builder = prepareHeaderContext(builder);
        builder = prepareQueryParameters(builder);

        builder.append("</HTTP>");

        return builder.toString();
    }

    private StringBuilder prepareDataContext(StringBuilder builder) {

        builder.append("<DATA>\n");
        builder.append(super.getData());
        builder.append("</DATA>\n");

        return builder;
    }

    private StringBuilder prepareHeaderContext(StringBuilder builder) {

        builder.append("<HEADER>");

        for(String header: super.getHeaders()) {
            builder.append("<HEADER>");
            builder.append(header);
            builder.append("</HEADER>");
        }

        builder.append("</HEADER>");

        return builder;
    }

    private StringBuilder prepareQueryParameters(StringBuilder builder) {

        builder.append("<QPARAMS>");
        builder.append("</QPARAMS>");

        for(String header: this.getQueryParameters()) {
            builder.append("<QPARAMS>\n");
            builder.append(header);
            builder.append("</QPARAMS>\n");
        }

        return builder;
    }
}
