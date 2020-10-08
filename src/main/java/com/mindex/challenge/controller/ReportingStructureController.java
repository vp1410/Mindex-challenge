package com.mindex.challenge.controller;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * We make use of @RestController as it is a combination of @Controller and @ResponseBody annotation.
 * It also converts response to JSON or XML
 */
@RestController
public class ReportingStructureController {
    private  static  final Logger LOG = LoggerFactory.getLogger(ReportingStructure.class);

    @Autowired
    ReportingStructureService reportingStructureService;

    /**
     * Task: New REST endpoint created which accepts employeeID and returns reportingStructure for that id
     *
     */
    @GetMapping("/reportingStructure/{id}")
    public ReportingStructure read(@PathVariable String id){
        LOG.debug("Read employee structure req for id[{}]",id);
        return reportingStructureService.readReportingStructure(id);
    }
}
