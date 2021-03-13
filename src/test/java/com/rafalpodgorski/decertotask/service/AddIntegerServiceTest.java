package com.rafalpodgorski.decertotask.service;

import com.rafalpodgorski.decertotask.datasource.DataSource;
import com.rafalpodgorski.decertotask.datasource.impl.JavaApi;
import com.rafalpodgorski.decertotask.datasource.impl.RandomApi;
import com.rafalpodgorski.decertotask.join.impl.AddIntegerService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddIntegerServiceTest {


    @Test
    public void shouldAddTwoDataSources() {
        DataSource<List<Integer>> javaApi = mock(JavaApi.class);
        DataSource<List<Integer>> randomApi = mock(RandomApi.class);
        AddIntegerService integerService = new AddIntegerService();

        when(javaApi.getData()).thenReturn(prepareJavaApiDataMock());
        when(randomApi.getData()).thenReturn(prepareRandomApiDataMock());

        int expectedValue = prepareExpectedNumber();
        assertEquals(expectedValue, integerService.join(javaApi, randomApi));
    }


    private Integer prepareExpectedNumber() {
        List<Integer> joinedData = Stream.concat(
                this.prepareJavaApiDataMock().stream(),
                this.prepareRandomApiDataMock().stream())
                .collect(Collectors.toList());
        int sum = joinedData.stream().mapToInt(number -> number).sum();
        return sum;
    }

    private List<Integer> prepareJavaApiDataMock() {
        return Stream.of(1, 5, 20, 30).collect(Collectors.toList());
    }

    private List<Integer> prepareRandomApiDataMock() {
        return Stream.of(2, 10, 40, 60).collect(Collectors.toList());
    }
}
