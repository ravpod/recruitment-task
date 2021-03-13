package com.rafalpodgorski.decertotask.join;

import com.rafalpodgorski.decertotask.datasource.DataSource;

import java.util.List;

public interface Joinable<T> {
    T join(DataSource<List<T>> DataSource, DataSource<List<T>> DataSource1);
}
