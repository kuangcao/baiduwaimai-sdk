package com.jiabangou.bdwmsdk.model;

import com.sun.tools.javac.util.List;

import java.io.Serializable;

public class Page<T> implements Serializable {

    private List<T> list;
    private int total;
    private int page;
    private int pages;

    public static <T> Page<T> build(List<T> list) {
        Page<T> page = new Page<T>();
        page.setList(list);
        return page;
    }

    public List<T> getList() {
        return list;
    }

    public Page<T> setList(List<T> list) {
        this.list = list;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public Page<T> setTotal(int total) {
        this.total = total;
        return this;
    }

    public int getPage() {
        return page;
    }

    public Page<T> setPage(int page) {
        this.page = page;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public Page<T> setPages(int pages) {
        this.pages = pages;
        return this;
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
