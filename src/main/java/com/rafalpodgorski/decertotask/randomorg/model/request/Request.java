package com.rafalpodgorski.decertotask.randomorg.model.request;

public class Request {
    private final String method;
    private final int id;
    private final String jsonrpc;
    private final Params params;

    public Request(String method, Params params) {
        this.method = method;
        this.params = params;
        this.id = 1;
        this.jsonrpc = "2.0";
    }

    public String getMethod() {
        return method;
    }

    public int getId() {
        return id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public Params getParams() {
        return params;
    }
}
