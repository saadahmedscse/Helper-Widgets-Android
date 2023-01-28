package com.saadahmedev.helperwidget.utils;

import java.util.HashMap;
import java.util.Map;

public class ShapeUtil {
    private static final Map<Shape, Float> shapeMap = new HashMap<>();
    private static final Float[] roundedShapes = {
            5F, 10F, 15F, 20F, 25F, 30F, 35F, 40F, 45F, 50F
    };

    public static ShapeUtil create() {
        for (int i = 0; i < roundedShapes.length; i++) shapeMap.put(Shape.values()[i], roundedShapes[i]);
        return new ShapeUtil();
    }

    public Float getShape(Shape key) {
        return shapeMap.get(key);
    }
}
