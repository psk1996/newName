package com.poortom.springboot.entity;

public class TParttimejob {
    private Integer ptjobid;

    private Integer issueid;

    private String ptname;

    private String starttime;

    private String overtime;

    private String moneyDay;

    private String address;

    private String activetext;

    public Integer getPtjobid() {
        return ptjobid;
    }

    public void setPtjobid(Integer ptjobid) {
        this.ptjobid = ptjobid;
    }

    public Integer getIssueid() {
        return issueid;
    }

    public void setIssueid(Integer issueid) {
        this.issueid = issueid;
    }

    public String getPtname() {
        return ptname;
    }

    public void setPtname(String ptname) {
        this.ptname = ptname == null ? null : ptname.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime == null ? null : overtime.trim();
    }

    public String getMoneyDay() {
        return moneyDay;
    }

    public void setMoneyDay(String moneyDay) {
        this.moneyDay = moneyDay == null ? null : moneyDay.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getActivetext() {
        return activetext;
    }

    public void setActivetext(String activetext) {
        this.activetext = activetext == null ? null : activetext.trim();
    }
}