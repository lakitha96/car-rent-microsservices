package com.carrent.rentprocesstask.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author Lakitha Prabudh on 7/7/20
 */
@Service
public class RentProcessServiceImpl implements RentProcessService {

    @Override
    public boolean validateDL(String dLNumber) {
        return dLNumber.length() > 4;
    }
}
