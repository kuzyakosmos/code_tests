package com.example.spring_practice;

import jakarta.annotation.PostConstruct;

@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 1, max = 10)
    private int repeat;

    private String message;

    public TerminatorQuoter() {
        System.out.println("Phase 1: repeat=" + repeat);
    }

    @PostConstruct
    public void init() {
        System.out.println("Phase 2: repeat=" + repeat);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void sayQuote() throws InterruptedException {
        System.out.println("Phase 3: repeat=" + repeat);
        for (int i = 0; i <= repeat; i++) {
            System.out.println("Message = " + message);
            Thread.sleep(500);
        }
    }
}
