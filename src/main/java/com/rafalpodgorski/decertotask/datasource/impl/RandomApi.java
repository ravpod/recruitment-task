package com.rafalpodgorski.decertotask.datasource.impl;

import com.rafalpodgorski.decertotask.config.properties.RandomProperties;
import com.rafalpodgorski.decertotask.datasource.DataSource;
import com.rafalpodgorski.decertotask.randomorg.model.request.Params;
import com.rafalpodgorski.decertotask.randomorg.model.request.Request;
import com.rafalpodgorski.decertotask.randomorg.model.response.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Qualifier("randomApi")
public class RandomApi implements DataSource<List<Integer>> {

    private final RandomProperties randomProperties;
    private final RestTemplate restTemplate;

    public RandomApi(RandomProperties randomProperties, RestTemplate restTemplate) {
        this.randomProperties = randomProperties;
        this.restTemplate = restTemplate;
    }


    @Override
    public List<Integer> getData() {
        int min = randomProperties.getMin();
        int max = randomProperties.getMax();
        int number = randomProperties.getNumber();
        Params params = new Params(min, max, number, true, randomProperties.getApiKey());
        Request request = new Request("generateIntegers", params);
        Response response = restTemplate.postForObject(randomProperties.getUrl(), request, Response.class);
        List<Integer> randomNumbers = response.getResult().getRandom().getData();
        return randomNumbers;
    }


}
