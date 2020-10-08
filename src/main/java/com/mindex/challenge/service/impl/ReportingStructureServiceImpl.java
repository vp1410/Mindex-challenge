package com.mindex.challenge.service.impl;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeService employeeService;

    public ReportingStructureServiceImpl(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @Override

    public ReportingStructure readReportingStructure(String id){
        LOG.debug("Reading the ReportingStructure [{}]", id);

        ReportingStructure reportingStructure = new ReportingStructure();
        Employee employee = employeeService.read(id);

        int numberOfReports = totalNumberOfReports(employee);
        reportingStructure.setNumberOfReports(numberOfReports);
        return reportingStructure;
    }

    public int totalNumberOfReports(Employee employee){
        int numberOfReports = 0;
        if(employee.getDirectReports() != null){
           for(Employee reports: employee.getDirectReports()){
               numberOfReports += 1;
               numberOfReports += totalNumberOfReports(employeeService.read(reports.getEmployeeId()));
           }
        }
        return  numberOfReports;
    }
}
