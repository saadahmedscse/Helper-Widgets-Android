package com.saadahmedev.helperwidget.utils;

public enum Shape {
    ROUNDED_5DP(5F),
    ROUNDED_10DP(10F),
    ROUNDED_15DP(15F),
    ROUNDED_20DP(20F),
    ROUNDED_25DP(25F),
    ROUNDED_30DP(30F),
    ROUNDED_35DP(35F),
    ROUNDED_40DP(40F),
    ROUNDED_45DP(45F),
    ROUNDED_50DP(50F),
    OVAL(0F),
    RING(0F),
    NORMAL(0F);

    private final Float value;

    Shape(Float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
