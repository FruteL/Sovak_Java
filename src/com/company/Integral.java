package com.company;

/**
 * CalcIntegral - function that calculate area under sinusoidal curve
 * Param:
 *      steps - responsible for the accuracy of the calculation
 *      startX, endX - responsible for limiting the X axis (start and end point respectively)
 *      BlockY - is responsible for limiting the Y-axis (from zero to the specified value).
 *      The value 0 means that the limit is not set.
 */
public class Sin {
    public static void main(String[] args){
        System.out.println(calcIntegralSin(10, 0, Math.PI, 0.9));
    }

    public static double calcIntegralSin (int steps, double startX, double endX, double blockY){
        double width = (endX - startX)/ steps;
        double area = 0;
        for (int i = 0; i < steps - 1; i++) {
            if (i >= startX) {
                double hight = Math.sin(i * width);
                if (hight >= blockY && blockY!=0)
                    hight = blockY;
                area += width * hight;
            }
        }
        return area;
    }







}
