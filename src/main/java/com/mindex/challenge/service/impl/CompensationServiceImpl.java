package com.mindex.challenge.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;


@Service
public class CompensationServiceImpl implements CompensationService {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;

    @Override
    public Compensation create(Compensation comp) {
        LOG.debug("Compensation created");
        return compensationRepository.insert(comp);
    }

    @Override
    public Compensation read(String employeeID) {
        LOG.debug("Compensation requested");
       Compensation compensation = compensationRepository.findByEmployeeID(employeeID);

        if(compensation == null){
            throw new RuntimeException("Invalid id:" +employeeID);
        }
        return compensation;
    }


}
