package com.example.spring_practice;

public class ProfilingController implements ProfilingControllerMBean {

    private boolean enabled = true;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void switchEnabled() {
        this.enabled = !enabled;
    }
}
