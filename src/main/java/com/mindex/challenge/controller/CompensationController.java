package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    /**
     * We make use of @RestController as it is a combination of @Controller and @ResponseBody annotation. It also
    converts response to JSON or XML
     */
@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

        /**
         * Task: There are two end points created i.e create and read
         * They persist and query compensation from persistence layer.
         */
    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation comp){
        return compensationService.create(comp);
     }

     @GetMapping("/compensation/{employeeID}")
    public Compensation read(@PathVariable String employeeID){
        return compensationService.read(employeeID);
     }
}
