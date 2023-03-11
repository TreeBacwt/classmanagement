package com.classmanagement.entity;

import java.util.Date;

public class Affair {

    private Integer id;
    private String affairName;
    private Date affairDate;
    private String information;
    private String result;

    public Affair() {
    }

    public Affair(Integer id, String affairName, Date affairDate, String information, String result) {
        this.id = id;
        this.affairName = affairName;
        this.affairDate = affairDate;
        this.information = information;
        this.result = result;
    }

    public Affair(String affairName, Date affairDate, String information, String result) {
        this.affairName = affairName;
        this.affairDate = affairDate;
        this.information = information;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Affair{" +
                "id=" + id +
                ", affairName='" + affairName + '\'' +
                ", affairDate=" + affairDate +
                ", information='" + information + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAffairName() {
        return affairName;
    }

    public void setAffairName(String affairName) {
        this.affairName = affairName;
    }

    public Date getAffairDate() {
        return affairDate;
    }

    public void setAffairDate(Date affairDate) {
        this.affairDate = affairDate;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
