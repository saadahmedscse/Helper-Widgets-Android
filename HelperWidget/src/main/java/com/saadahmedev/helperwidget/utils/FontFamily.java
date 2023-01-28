package com.saadahmedev.helperwidget.utils;

public enum FontFamily {
    REGULAR("regular.ttf"),
    MEDIUM("medium.ttf"),
    BOLD("bold.ttf");

    private final String value;

    FontFamily(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
