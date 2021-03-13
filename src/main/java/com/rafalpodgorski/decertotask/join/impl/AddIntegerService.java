package com.rafalpodgorski.decertotask.join.impl;

import com.rafalpodgorski.decertotask.datasource.DataSource;
import com.rafalpodgorski.decertotask.join.Joinable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AddIntegerService implements Joinable<Integer> {


    @Override
    public Integer join(DataSource<List<Integer>> dataSource, DataSource<List<Integer>> dataSource1) {
        List<Integer> dataSourceElements = dataSource.getData();
        List<Integer> dataSource1Elements = dataSource1.getData();
        List<Integer> joinedData = Stream.concat(dataSourceElements.stream(), dataSource1Elements.stream()).collect(Collectors.toList());
        int sum = joinedData.stream().mapToInt(number -> number).sum();
        return sum;
    }
}
