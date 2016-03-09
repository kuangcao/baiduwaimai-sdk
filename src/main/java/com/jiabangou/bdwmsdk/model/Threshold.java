package com.jiabangou.bdwmsdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-3-3.
 */
public class Threshold implements Serializable {

    //初始化值
    private Integer num;

    //初始化时间 "time": "0|9|*"
    private String time;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Threshold threshold = (Threshold) o;

        if (num != null ? !num.equals(threshold.num) : threshold.num != null) return false;
        return time != null ? time.equals(threshold.time) : threshold.time == null;

    }

    @Override
    public int hashCode() {
        int result = num != null ? num.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Threshold{" +
                "num=" + num +
                ", time='" + time + '\'' +
                '}';
    }
}
