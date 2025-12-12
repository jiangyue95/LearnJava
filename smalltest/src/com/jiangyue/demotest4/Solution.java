package com.jiangyue.demotest4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Liquid water = new Liquid("water", 4, 24);
        Liquid milk = new Liquid("milk", 8, 160);
        Liquid wuliangye = new Liquid("wuliangye", 2, 4000);
        Liquid cola = new Liquid("cola", 6, 108);
        Liquid maotai = new Liquid("maotai", 1, 4000);
        List<Liquid> liquids = new ArrayList();
        liquids.add(water);
        liquids.add(milk);
        liquids.add(wuliangye);
        liquids.add(cola);
        liquids.add(maotai);
        Collections.sort(liquids);
        getLiquids(liquids);
        System.out.println(water.getName());
    }

    private static void getLiquids(List<Liquid> liquids) {
        double remainingCapacity = 10;
        List<Double> volumes = new ArrayList();
        double totalValue = 0;
        for (Liquid liquid : liquids) {
            if (remainingCapacity <= 0) {
                break;
            }
            double take = Math.min(liquid.getVolume(), remainingCapacity);
            remainingCapacity -= take;
            volumes.add(take);
            totalValue += take * liquid.getUnitValue();
            System.out.println(liquid.getName() + ": " + take);
        }
        System.out.println(volumes);
        System.out.println(totalValue);
    }
}
