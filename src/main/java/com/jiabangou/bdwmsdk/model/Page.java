package com.jiabangou.bdwmsdk.model;

import java.util.List;

import java.io.Serializable;

public class Page<T> implements Serializable {

    private List<T> list;
    private int total;
    private int page;
    private int pages;

//    public Page() {
//    }
//
//    public static <T> Page<T> build(List<T> list) {
//        Page<T> page = new Page<T>();
//        page.setList(list);
//        return page;
//    }
//
//    public List<T> getList() {
//        return list;
//    }
//
//    public Page<T> setList(List<T> list) {
//        this.list = list;
//        return this;
//    }
//
//    public int getTotal() {
//        return total;
//    }
//
//    public Page<T> setTotal(int total) {
//        this.total = total;
//        return this;
//    }
//
//    public int getPage() {
//        return page;
//    }
//
//    public Page<T> setPage(int page) {
//        this.page = page;
//        return this;
//    }
//
//    public int getPages() {
//        return pages;
//    }
//
//    public Page<T> setPages(int pages) {
//        this.pages = pages;
//        return this;
//    }
//
//    @Override
//    public String toString() {
//        return "Page{" +
//                "list=" + list +
//                ", total=" + total +
//                ", page=" + page +
//                ", pages=" + pages +
//                '}';
//    }


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
