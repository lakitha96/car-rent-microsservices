package com.carrent.rentprocesstask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 * @author Lakitha Prabudh on 7/7/20
 */
public class RentProcessTaskRunner implements CommandLineRunner {

    @Autowired
    private RentProcessService rentProcessService;

    //just for a example

    /**
     * Asynchronous short lived [born do the job and die its own]
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        if (args.length>0) {
            System.out.println("task running with argument");
            if (rentProcessService.validateDL(args[0])) {
                System.out.println("Valid driving license");
            } else {
                System.out.println("Invalid driving license");
            }
        } else {
            System.out.println("task running without argument");
        }

    }
}
