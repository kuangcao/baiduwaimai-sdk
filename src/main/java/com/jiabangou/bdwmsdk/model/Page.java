package com.jiabangou.bdwmsdk.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;
import java.util.List;
@JSONType
public class Page<T> implements Serializable {

    private List<T> list;
    private int total;
    private int page;
    private int pages;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Page<?> page1 = (Page<?>) o;

        if (total != page1.total) return false;
        if (page != page1.page) return false;
        if (pages != page1.pages) return false;
        return list != null ? list.equals(page1.list) : page1.list == null;

    }

    @Override
    public int hashCode() {
        int result = list != null ? list.hashCode() : 0;
        result = 31 * result + total;
        result = 31 * result + page;
        result = 31 * result + pages;
        return result;
    }

    @Override
    public String toString() {
        return "Page{" +
                "list=" + list +
                ", total=" + total +
                ", page=" + page +
                ", pages=" + pages +
                '}';
    }
}
