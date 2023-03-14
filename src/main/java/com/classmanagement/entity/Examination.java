package com.classmanagement.entity;

import java.util.Date;

public class Examination {

    private Integer id;
    private String examinationName;
    private Date examinationDate;

    public Examination() {
    }

    public Examination(Integer id, String examinationName, Date examinationDate) {
        this.id = id;
        this.examinationName = examinationName;
        this.examinationDate = examinationDate;
    }

    public Examination(String examinationName, Date examinationDate) {
        this.examinationName = examinationName;
        this.examinationDate = examinationDate;
    }

    @Override
    public String toString() {
        return "Examination{" +
                "id=" + id +
                ", examinationName='" + examinationName + '\'' +
                ", examinationDate=" + examinationDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExaminationName() {
        return examinationName;
    }

    public void setExaminationName(String examinationName) {
        this.examinationName = examinationName;
    }

    public Date getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(Date examinationDate) {
        this.examinationDate = examinationDate;
    }
}
