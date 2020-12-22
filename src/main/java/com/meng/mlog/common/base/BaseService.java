package com.meng.mlog.common.base;

import com.meng.mlog.common.result.model.ResultList;

import java.util.List;

public interface BaseService<T> {

    default ResultList<T> createResultList(List<T> items, Integer total) {
        return new ResultList<>(items, total);
    }

}
