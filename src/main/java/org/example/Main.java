package org.example;
import umontreal.iro.lecuyer.functions.*;

public class Main {
    public static void main(String[] args) {

        MyFunction f = new MyFunction();
        double a = -1.5;
        double b = -0.75;
        //double epsilon = 0.0000000001;
        double epsilon =   0.0000000001;

        //NewtonsMethod(a,b,epsilon,f);
        SecantsMethod(a,b,epsilon,f);

    }

    private static double NewtonsMethod(double a, double b, double epsilon, MathFunction f) {
        if (f.evaluate(a)*f.evaluate(b)>=0) {
            throw new ArithmeticException("Znaki wartosci funkcji na krancach przedzialow nie sa rozne");
        }

        double x0;

        if ((f.evaluate(a)*MathFunctionUtil.derivative(f,a,2))>0) {
            x0 = a;
        } else if ((f.evaluate(b)*MathFunctionUtil.derivative(f,b,2))>0) {
            x0 = b;
        } else {
            throw new ArithmeticException();
        }


        double x1 = x0 - (f.evaluate(x0)/MathFunctionUtil.derivative(f,x0,1));
        int i = 1;

        while (Math.abs(f.evaluate(x1)) > epsilon) {
            x1 = x1 - (f.evaluate(x1)/MathFunctionUtil.derivative(f,x1,1));
            i++;
        }

        System.out.println("miejsce zerowe to: " + x1 + " po " + i + " iteracjach.");
        return x1;
    }
    private static double SecantsMethod(double a, double b, double epsilon, MathFunction f) {
        double x0;
        double x1;
        if (f.evaluate(a)*MathFunctionUtil.derivative(f,a,2)>0) {
            x0 = b;
            x1 = a;
        } else if (f.evaluate(b)*MathFunctionUtil.derivative(f,b,2)>0) {
            x0 = a;
            x1 = b;
        } else {
            throw new ArithmeticException();
        }

        int i = 1;
        double x = SecantMethodFormula(f,x0,x1);
        while (Math.abs(f.evaluate(x)) > epsilon) {
            x0 = x1;
            x1 = x;
            x = SecantMethodFormula(f,x0,x1);
            i++;
        }
        System.out.println("Miejsce zerowe wynosi " + x + " po " + i + " iteracjach.");
        return 0;
    }
    private static double SecantMethodFormula(MathFunction f, double x0, double x1) {
        return x1 - ( f.evaluate(x1) / ( f.evaluate(x0) - f.evaluate(x1) ) ) * ( x0 - x1);
    }

}