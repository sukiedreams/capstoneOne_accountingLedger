package com.ps;

public class Transaction {

    private String date;
    private String time;
    private String description;
    private String vendor;
    private Double amount;

    public Transaction(String date, String time, String description, String vendor, Double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String toString() {
        return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
    }

    public String toCSV() {
        return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
    }
}
