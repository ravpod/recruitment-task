package com.rafalpodgorski.decertotask.datasource.impl;

import com.rafalpodgorski.decertotask.config.properties.RandomProperties;
import com.rafalpodgorski.decertotask.datasource.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Qualifier("javaApi")
public class JavaApi implements DataSource<List<Integer>> {

    private final RandomProperties randomProperties;

    public JavaApi(RandomProperties randomProperties) {
        this.randomProperties = randomProperties;
    }

    @Override
    public List<Integer> getData() {
        int min = randomProperties.getMin();
        int max = randomProperties.getMax();
        int number = randomProperties.getNumber();
        Random random = new Random();
        IntStream intStream = random.ints(number, min, max);
        List<Integer> randomNumbers = intStream.boxed().collect(Collectors.toList());
        return randomNumbers;
    }
}
