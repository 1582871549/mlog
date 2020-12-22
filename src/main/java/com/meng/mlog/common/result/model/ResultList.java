package com.meng.mlog.common.result.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResultList<T> implements Serializable {

    private static final long serialVersionUID = 2613006242860927638L;
    private List<T> items;
    private Integer total;

    public ResultList(List<T> items) {
        this.items = items;
    }

    public ResultList(List<T> items, Integer total) {
        this.items = items;
        this.total = total;
    }
}
