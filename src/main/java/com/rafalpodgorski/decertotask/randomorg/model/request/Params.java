package com.rafalpodgorski.decertotask.randomorg.model.request;

public class Params {
    private final int min;
    private final String apiKey;
    private final int max;
    private final boolean replacement;
    private final int n;

    public Params(int min, int max, int n, boolean replacement, String apiKey) {
        this.min = min;
        this.apiKey = apiKey;
        this.max = max;
        this.n = n;
        this.replacement = replacement;
    }


    public int getMin() {
        return min;
    }

    public String getApiKey() {
        return apiKey;
    }

    public int getMax() {
        return max;
    }

    public boolean isReplacement() {
        return replacement;
    }

    public int getN() {
        return n;
    }
}
