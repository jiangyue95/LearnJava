package com.jiangyue.demo4genericity;

import java.util.ArrayList;

public class GenericDemo5 {
    public static void main(String[] args) {
        ArrayList<Xiaomi> xiaomis = new ArrayList<>();
        xiaomis.add(new Xiaomi());
        xiaomis.add(new Xiaomi());
        xiaomis.add(new Xiaomi());
        go(xiaomis);

        ArrayList<LX> lxs = new ArrayList<>();
        lxs.add(new LX());
        lxs.add(new LX());
        lxs.add(new LX());
        go(lxs);
    }

    // 需求开发一个极品飞车游戏。
    // 虽然 Xiaomi 和 LX 是 Car 的子集，但是 ArrayList<Xiaomi> 和 ArrayList<LX> 是没有关系的
    public static void go(ArrayList<? extends Car> cars) {
    }
}
