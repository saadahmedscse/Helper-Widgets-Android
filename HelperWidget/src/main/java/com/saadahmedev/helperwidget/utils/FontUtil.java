package com.saadahmedev.helperwidget.utils;

import java.util.HashMap;
import java.util.Map;

public class FontUtil {
    private static final Map<FontFamily, String> fontMap = new HashMap<>();
    private static final String[] fonts = {
            "regular.ttf",
            "medium.ttf",
            "bold.ttf"
    };

    public FontUtil() {
        for (int i = 0; i < fonts.length; i++) fontMap.put(FontFamily.values()[i], fonts[i]);
    }

    public String getFont(FontFamily key) {
        return fontMap.get(key);
    }
}
