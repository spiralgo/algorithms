package algorithms;

import java.util.Random;

public class PiApproximation {
    public static double randomValuesMethod() {
        //Question: Estimate Pi using two random number generators.
        
        Random rand = new Random();
        double piAppr = 0; //Pi Approximation
        int numOfPoints = 1000000;
        for (int i = 0; i < numOfPoints; i++) {
            double xValue = rand.nextDouble();
            double yValue = rand.nextDouble();
            if (Math.sqrt(xValue * xValue + yValue * yValue) <= 1) { //If it's inside the circle.
                piAppr++;
            }
        }
        //piAppr = area*numberOfPoints = radius*radius*pi*numberOfPoints
        //radius = 0.5 = > piAppr = 0.25*pi*numberOfPoints =>
        piAppr = piAppr * 4 / numOfPoints;
        return piAppr;
    }

    public static void main(String[] args) {
        System.out.println(randomValuesMethod()); //Prints something around 3,141
    }
}
