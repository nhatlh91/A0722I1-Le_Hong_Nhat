package com.example.thi.models;

import java.sql.Date;

public class Family {
    private int fid;
    private String host;
    private int members;
    private Date createDate;
    private String address;

    public Family() {
    }

    public Family(int fid, String host, int members, Date createDate, String address) {
        this.fid = fid;
        this.host = host;
        this.members = members;
        this.createDate = createDate;
        this.address = address;
    }

    public int getFid() {
        return fid;
    }

    public String getHost() {
        return host;
    }

    public int getMembers() {
        return members;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getAddress() {
        return address;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Family{" +
                "fid=" + fid +
                ", host='" + host + '\'' +
                ", members=" + members +
                ", createDate=" + createDate +
                ", address='" + address + '\'' +
                '}';
    }
}
