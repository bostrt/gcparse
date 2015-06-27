package com.redhat.gcparser.model;

import java.text.DecimalFormat;

/**
 * Created by rbost on 6/26/15.
 */
public class Times {
    private double user;
    private double system;
    private double real;

    public Times(double user, double system, double real) {
        this.user = user;
        this.system = system;
        this.real = real;
    }

    public double getUser() {
        return user;
    }

    public void setUser(double user) {
        this.user = user;
    }

    public double getSystem() {
        return system;
    }

    public void setSystem(double system) {
        this.system = system;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    @Override
    public String toString() {
        // [Times: user=0.31 sys=0.00, real=0.24 secs]
        DecimalFormat df = new DecimalFormat("#.00");
        return String.format("[Times: user=%s sys=%s, real=%s sec]", df.format(user), df.format(system), df.format(real));
    }
}
