package com.example.spring_practice;

public class T1000 extends TerminatorQuoter implements Quoter {
    @Override
    public void sayQuote() throws InterruptedException {
        System.out.println("I'm liquid!!!");
    }
}
