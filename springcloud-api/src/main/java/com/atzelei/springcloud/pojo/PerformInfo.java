package com.atzelei.springcloud.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@Data
public class PerformInfo implements Serializable {
    private Long id;

    private String title;

    private Integer perfortype;

    private String performstar;

    private Integer performpice;

    private String performshows;

    private String performplace;

    private Date performstarttime;

    private Date performendtime;

    private Integer performheat;

    private String performposters;

    private Float performdiscount;

    private Byte isdelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getPerfortype() {
        return perfortype;
    }

    public void setPerfortype(Integer perfortype) {
        this.perfortype = perfortype;
    }

    public String getPerformstar() {
        return performstar;
    }

    public void setPerformstar(String performstar) {
        this.performstar = performstar == null ? null : performstar.trim();
    }

    public Integer getPerformpice() {
        return performpice;
    }

    public void setPerformpice(Integer performpice) {
        this.performpice = performpice;
    }

    public String getPerformshows() {
        return performshows;
    }

    public void setPerformshows(String performshows) {
        this.performshows = performshows == null ? null : performshows.trim();
    }

    public String getPerformplace() {
        return performplace;
    }

    public void setPerformplace(String performplace) {
        this.performplace = performplace == null ? null : performplace.trim();
    }

    public Date getPerformstarttime() {
        return performstarttime;
    }

    public void setPerformstarttime(Date performstarttime) {
        this.performstarttime = performstarttime;
    }

    public Date getPerformendtime() {
        return performendtime;
    }

    public void setPerformendtime(Date performendtime) {
        this.performendtime = performendtime;
    }

    public Integer getPerformheat() {
        return performheat;
    }

    public void setPerformheat(Integer performheat) {
        this.performheat = performheat;
    }

    public String getPerformposters() {
        return performposters;
    }

    public void setPerformposters(String performposters) {
        this.performposters = performposters == null ? null : performposters.trim();
    }

    public Float getPerformdiscount() {
        return performdiscount;
    }

    public void setPerformdiscount(Float performdiscount) {
        this.performdiscount = performdiscount;
    }

    public Byte getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Byte isdelete) {
        this.isdelete = isdelete;
    }
}