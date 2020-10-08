package com.mindex.challenge.data;

import jdk.jfr.internal.Repository;

public class ReportingStructure {
    private int numberOfReports;
    private Employee employee;

    public ReportingStructure(){

    }
     public Employee getEmployee(){
        return  employee;

     }

     public void setEmployee(Employee employee){
        this.employee = employee;
     }

     public int getNumberOfReports(){
        return  numberOfReports;
     }

     public void setNumberOfReports(int numberOfReports){
        this.numberOfReports = numberOfReports;
     }
}
