package com.mindex.challenge.data;

public class Compensation {
    private String employeeID;
    private int salary;
    private String effectiveDate;

    public Compensation(){}

    public String getEmployee(){
        return employeeID;
    }
    public void setEmployee(String employeeID){
        this.employeeID = employeeID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEffectiveDate(){
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
