package com.jiangyue.demotest2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Integer> prisonerList = generatePrisonerList();
        luckyOne(prisonerList);
        System.out.println("==========");
        luckyOne2(prisonerList);
    }
    private static List<Integer> generatePrisonerList() {
        Set<Integer> prisonerSet = new TreeSet<>();
        while(prisonerSet.size() < 100) {
            prisonerSet.add((int) (Math.random() * 200 + 1));
        }
        List<Integer> prisonerList = new ArrayList<>(prisonerSet);
        return prisonerList;
    }

    private static void luckyOne(List<Integer> prisonerList) {
        List<Integer> originalList = prisonerList;
        while(prisonerList.size() > 1) {
            List<Integer> nextList = new ArrayList<>();
            System.out.println("Prisoner number: " + prisonerList);
            for (int i = 0; i < prisonerList.size(); i++) {
                int position = i + 1; // 位置=索引+1
                if (position % 2 == 0) { // 偶数位置保留
                    nextList.add(prisonerList.get(i));
                }
            }
            // 保留的编号变为现在的编号
            prisonerList = nextList;
        }
        int survivor = prisonerList.get(0);
        int index = originalList.indexOf(survivor);
        int postion = index + 1;
        System.out.println("The last prisoner's number is: " + survivor + " and the position is: " + postion);
    }

    private static void luckyOne2(List<Integer> prisonerList) {
        List<Integer> originalList = prisonerList;
        List<Integer> finalList = elimate(prisonerList);
        int survivor = finalList.get(0);
        int index = originalList.indexOf(survivor);
        int postion = index + 1;
        System.out.println("The last prisoner's number is: " + survivor + " and the position is: " + postion);
    }

    private static List<Integer> elimate(List<Integer> current) {
        if (current.size() == 1) {
            return current;
        }
        List<Integer> next = new ArrayList<>();
        for (int i = 0; i < current.size(); i++) {
            int position = i + 1;
            if (position % 2 == 0) {
                next.add(current.get(i));
            }
        }
        return elimate(next);
    }
}
