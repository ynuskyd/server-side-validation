package com.server.request;

public abstract class ProtocolRequest {

    private String data;
    private String[] headers;

    public ProtocolRequest(String data) {
        this.data = data;
    }

    public ProtocolRequest(String data, String[] headers) {
        this.data = data;
        this.headers = headers;
    }

    public String getData() {
        return data;
    }

    public String[] getHeaders() {
        return headers;
    }

    public void addHeader(String header) {
        this.headers[this.headers.length-1] = header;
    }
//bu methodu ihtiyaca göre alt sınıflar dolduracak.
    public abstract String prepareContext();
}
