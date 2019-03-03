package com.nam.parser;

public class ParseReader {
    private String name;
    private int salaryFrom;
    private int salaryTo;
    private String salaryCurrency;
    private boolean salaryGross;
    private String publishedAt;
    private String employerName;

    public void setName(String name) {
        this.name = name;
    }

    public void setSalaryFrom(int salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    public void setSalaryTo(int salaryTo) {
        this.salaryTo = salaryTo;
    }

    public void setSalaryCurrency(String salaryCurrency) {
        this.salaryCurrency = salaryCurrency;
    }

    public void setSalaryGross(boolean salaryGross) {
        this.salaryGross = salaryGross;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    private static int i = 0;

    public void process(){
        System.out.println(++i + " " + toString());
    }

    @Override
    public String toString() {
        return "ParseReader{" +
                "name='" + name + '\'' +
                ", salaryFrom=" + salaryFrom +
                ", salaryTo=" + salaryTo +
                ", salaryCurrency=" + salaryCurrency +
                ", salaryGross=" + salaryGross +
                ", publishedAt='" + publishedAt + '\'' +
                ", employerName='" + employerName + '\'' +
                '}';
    }
}
