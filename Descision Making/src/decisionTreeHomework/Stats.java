/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisionTreeHomework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author mhrcek
 */
public class Stats {

    public static Random random = new Random();

    public static int distributedIntegerValue(double lambda) {
        int result = 0;
        double scaler = Math.exp(-lambda);
        double adder = scaler;
        double ran = random.nextDouble();

        while (ran > adder) {
            ++result;
            scaler *= lambda / result;
            adder += scaler;
        }

        return result;
    }

    public static double getAverage(ArrayList<Double> values) {

        double average = 0;

        for (Double d : values) {
            average += d;
        }

        return average / values.size();
    }

    public static Map<Integer, Integer> generateDistributionMap(ArrayList<Integer> values) {
        Map<Integer, Integer> distribution = new HashMap<>();
        for (Integer i : values) {
            if (distribution.containsKey(i)) {
                distribution.put(i, distribution.get(i) + 1);
            } else {
                distribution.put(i, 1);
            }
        }
        return distribution;
    }

    public static Map<Integer, Integer> sortMap(Map<Integer, Integer> mapToSort, int bound) {

        Map<Integer, Integer> sortedMap = new HashMap<>();

        for (Integer itter = 0; itter < bound; itter += 1) {
            if (mapToSort.containsKey(itter)) {
                sortedMap.put(itter, mapToSort.get(itter));
            }
        }

        return sortedMap;
    }

    public static double getPercentageMatchingTargetValue(ArrayList<Double> valuesDouble, double targetValueDouble) {
        
        Integer targetValue = scaleUp1000x(targetValueDouble);
        ArrayList<Integer> values = scaleUp1000x(valuesDouble);
        
        Map<Integer, Integer> map = generateDistributionMap(values);

        if (map.containsKey(targetValue)) {
            return map.get(targetValue) / (double) values.size();
        }

        return 0;
    }

    private static double getPercentageMatchingTargetValue(Map<Integer, Integer> map, Integer targetValue, double size) {
        
        if (map.containsKey(targetValue)) {
            return map.get(targetValue) / size;
        }

        return 0;
    }

    public static double[] getPercentRange(ArrayList<Double> valuesDouble, Integer percentage, double targetValueDouble, Integer maxBound) {
        double[] zrange = new double[2];
        double targetPercentage = percentage / 200.0;

        Integer targetValue = scaleUp1000x(targetValueDouble);
        ArrayList<Integer> values = scaleUp1000x(valuesDouble);
        
        Map<Integer, Integer> distribution = generateDistributionMap(values);
        distribution = sortMap(distribution, maxBound);

        double percentageLeft = 0, percentageRight = 0;
        percentageLeft += getPercentageMatchingTargetValue(distribution, targetValue, values.size()) / 2.0;
        percentageRight += getPercentageMatchingTargetValue(distribution, targetValue, values.size()) / 2.0;

        double leftValue = 0, rightValue = 0;

        for (int i = targetValue - 1; i >= 0; i--) {
            if (distribution.containsKey(i)) {
                if (getPercentageMatchingTargetValue(distribution, i, values.size()) + percentageLeft <= targetPercentage) {
                    percentageLeft += getPercentageMatchingTargetValue(distribution, i, values.size());
                } else {
                    double percentageNeeded = targetPercentage - percentageLeft;
                    double multiplier = percentageNeeded / getPercentageMatchingTargetValue(distribution, i, values.size());
                    leftValue = i + 1 - multiplier;
                    break;
                }
            }
        }
        for (int i = targetValue + 1; i <= maxBound; i++) {
            if (distribution.containsKey(i)) {
                if (getPercentageMatchingTargetValue(distribution, i, values.size()) + percentageRight <= targetPercentage) {
                    percentageRight += getPercentageMatchingTargetValue(distribution, i, values.size());
                } else {
                    double percentageNeeded = targetPercentage - percentageRight;
                    double multiplier = percentageNeeded / getPercentageMatchingTargetValue(distribution, i, values.size());
                    rightValue = i - 1 + multiplier;
                    break;
                }
            }
        }

        zrange[0] = leftValue;
        zrange[1] = rightValue;

        return zrange;
    }

    private static ArrayList<Integer> scaleUp1000x(ArrayList<Double> nums){
        ArrayList<Integer> intNums = new ArrayList<>();
        for(double d: nums){
            d *= 1000;
            intNums.add((int)Math.round(d));
        }
        return intNums;
    }
    
    private static int scaleUp1000x(double num){
        return (int)Math.round(num*1000);
    }
    
    public static double calculateUncertainty(double lower, double upper, double size) {
        double avg = (lower + upper) / 2.0;
        return avg / size * 100;
    }

    static Double getMaxValueInArray(ArrayList<Double> array) {
        double max = array.get(0);
        for (Double d : array) {
            if (d > max) {
                max = Math.max(d, max);
            }
        }
        return max;
    }

}
