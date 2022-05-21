package com.company.models;

import java.util.Date;

public class JournalItem {
    Date date;
    Boolean isEnter;

    public JournalItem(Boolean isEnter) {
        this.date = new Date();
        this.isEnter = isEnter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getEnter() {
        return isEnter;
    }

    public void setEnter(Boolean enter) {
        isEnter = enter;
    }

    @Override
    public String toString() {
        return "JournalItem{" +
                "date=" + date +
                ", isEnter=" + isEnter +
                '}';
    }
}
