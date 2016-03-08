package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

/**
 * 营业时间
 * Created by konghang on 16/3/3.
 */
public class BussinessTime implements Serializable {

    private String start;

    private String end;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BussinessTime that = (BussinessTime) o;

        if (start != null ? !start.equals(that.start) : that.start != null) return false;
        return end != null ? end.equals(that.end) : that.end == null;

    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BussinessTime{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
