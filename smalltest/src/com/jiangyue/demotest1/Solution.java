package com.jiangyue.demotest1;

import lombok.Data;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Integer> myNumber = generateDoubleColorBall();
        System.out.println("My number: " + myNumber);
        List<Integer> targetNumber = List.of(10, 12, 30, 16, 7, 17, 12);
        System.out.println("Target number: " + targetNumber);
        checkNumbers(myNumber, targetNumber);
    }

    private static void checkNumbers(List<Integer> myNumber, List<Integer> targetNumber) {
        if (myNumber.size() != targetNumber.size()) {
            System.out.println("The two numbers are not the same length.");
        }
        Set<Integer> myRedBalls = new HashSet<>(myNumber.subList(0, 6));
        Set<Integer> targetRedBalls = new HashSet<>(targetNumber.subList(0, 6));

        Set<Integer> intersection = new HashSet<>(myRedBalls);
        intersection.retainAll(targetRedBalls);
        int redCount = intersection.size();

        int blueCount = Objects.equals(myNumber.get(6), targetNumber.get(6)) ? 1 : 0;

        System.out.println("Redball same number count: " + redCount);
        System.out.println("Blueball same number count: " + blueCount);
    }

    private static List<Integer> generateDoubleColorBall() {
        Set<Integer> redBalls = new HashSet<>();
        while (redBalls.size() < 6) {
            redBalls.add((int) (Math.random() * 35 + 1));
        }
        List<Integer> sortedRedBalls = new ArrayList<>(redBalls);
        Collections.sort(sortedRedBalls);
        int blueBall = (int) (Math.random() * 15 + 1);
        List<Integer> result = new ArrayList<>();
        result.addAll(sortedRedBalls);
        result.add(blueBall);
        return result;
    }
}

@Data
class Prisoner {
    private int id;
    private int firstLocation;
}
