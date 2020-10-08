package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* We are making use of @Service as it provides logic to operate on data sent to and from DAO and client */
@Service
public class CompensationServiceImpl implements CompensationService {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;

    /**
     * Here we insert the compensation data
     * @param comp object has employeeID, salary, effectiveData
     * @return comp object
     */
    @Override
    public Compensation create(Compensation comp) {
        LOG.debug("Compensation creation [{}]",comp);
        return compensationRepository.insert(comp);
    }

    /**
     * Here we read the compensation data that exists
     * @param employeeID is required to get information
     * @return compensation
     */
    @Override
    public Compensation read(String employeeID) {
        LOG.debug("Compensation requested [{}]",employeeID);
        Compensation compensation =  compensationRepository.findByEmployeeID(employeeID);
        if(compensation == null){
            throw new RuntimeException("Invalid employeeID: " + employeeID);
        }
        return compensation;
    }
}
