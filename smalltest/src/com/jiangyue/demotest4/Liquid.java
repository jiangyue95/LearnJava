package com.jiangyue.demotest4;

public class Liquid implements Comparable<Liquid> {
    private String name;
    private int volume;
    private int value;

    public Liquid() {
    }

    public Liquid(String name,int volume, int value) {
        this.name = name;
        this.volume = volume;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getUnitValue() {
        return value / (double) volume;
    }

    @Override
    public int compareTo(Liquid other) {
        return Double.compare(other.getUnitValue(), this.getUnitValue());
    }
}
