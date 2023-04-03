package org.example;

import umontreal.iro.lecuyer.functions.MathFunction;

public class MyFunction implements MathFunction {
    @Override
    public double evaluate(double v) {
        return (v+1)*Math.pow((v-1),4);
    }
}
