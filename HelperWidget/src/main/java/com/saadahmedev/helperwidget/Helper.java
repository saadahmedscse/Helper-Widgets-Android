/*
 * Copyright 2018-2023 Saad Ahmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.saadahmedev.helperwidget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;

import androidx.annotation.NonNull;

import com.saadahmedev.helperwidget.interfaces.OnClickListener;
import com.saadahmedev.helperwidget.interfaces.OnLongPressListener;
import com.saadahmedev.helperwidget.utils.Clickable;
import com.saadahmedev.helperwidget.utils.ColorUtil;
import com.saadahmedev.helperwidget.utils.Colors;
import com.saadahmedev.helperwidget.utils.DimenUtil;
import com.saadahmedev.helperwidget.utils.Shape;
import com.saadahmedev.helperwidget.widgets.ImageView;

public class Helper {

    private static GradientDrawable shape;
    @SuppressLint("StaticFieldLeak")
    private static View view;
    private static TypedArray typedArray;
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    @SuppressLint("StaticFieldLeak")
    private static DimenUtil dimenUtil;

    //Colors
    private static @NonNull
    Integer rippleColor = 0;

    //CornerRadius
    private static @NonNull
    Float cornerRadius = 0.0f;
    private static @NonNull
    Float topLeftCornerRadius = 0.0f;
    private static @NonNull
    Float topRightCornerRadius = 0.0f;
    private static @NonNull
    Float bottomRightCornerRadius = 0.0f;
    private static @NonNull
    Float bottomLeftCornerRadius = 0.0f;

    //Stroke
    private static @NonNull
    Float strokeWidth = 2F;
    private static @NonNull
    Integer strokeColor = ColorUtil.parseColor(Colors.COLOR_DARK_GRAY);

    public static void initView(View view, Context context, TypedArray typedArray, GradientDrawable shape) {
        Helper.dimenUtil = DimenUtil.getInstance(context);
        Helper.view = view;
        Helper.shape = shape;
        Helper.typedArray = typedArray;
        Helper.context = context;
    }

    public static void initDefaultCornerRadius(int[] attrIds) {
        if (!(view instanceof ImageView)) {
            topLeftCornerRadius = typedArray.getDimension(attrIds[1], 0.0f);
            topRightCornerRadius = typedArray.getDimension(attrIds[2], 0.0f);
            bottomRightCornerRadius = typedArray.getDimension(attrIds[3], 0.0f);
            bottomLeftCornerRadius = typedArray.getDimension(attrIds[4], 0.0f);
        }
        cornerRadius = typedArray.getDimension(attrIds[0], 0.0f);

        Helper.setRadius();
    }

    private static void setRadius() {
        if (!cornerRadius.equals(0.0F)) {
            shape.setCornerRadius(cornerRadius);
        } else {
            shape.setCornerRadii(new float[]{
                    topLeftCornerRadius,
                    topLeftCornerRadius,
                    topRightCornerRadius,
                    topRightCornerRadius,
                    bottomRightCornerRadius,
                    bottomRightCornerRadius,
                    bottomLeftCornerRadius,
                    bottomLeftCornerRadius
            });
        }
    }

    public static void initDefaultColors(int[] attrIds) {
        shape.setColor(typedArray.getColor(attrIds[0], Color.TRANSPARENT));
        rippleColor = typedArray.getColor(attrIds[1], Color.TRANSPARENT);
    }

    public static void initDefaultShape(int attrId) {
        Shape viewShape = Shape.values()[typedArray.getInt(attrId, 12)];
        switch (viewShape) {
            case OVAL:
                shape.setShape(GradientDrawable.OVAL);
                break;
            case RING: {
                shape.setShape(GradientDrawable.OVAL);
                shape.setColor(Color.TRANSPARENT);
                shape.setStroke(strokeWidth.intValue(), strokeColor);
                break;
            }
            case NORMAL: break;
            default:
                shape.setCornerRadius(dimenUtil.floatToDp(viewShape.getValue()));
        }
    }

    public static void initDefaultStroke(int[] attrIds) {
        strokeWidth = typedArray.getDimension(attrIds[0], 0);
        strokeColor = typedArray.getColor(attrIds[1], 0);
        shape.setStroke(strokeWidth.intValue(), strokeColor);

        if (view instanceof ImageView) {
            view.setPadding(strokeWidth.intValue(), strokeWidth.intValue(), strokeWidth.intValue(), strokeWidth.intValue());
        }
    }

    private static RippleDrawable getRippleDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return new RippleDrawable(getPressedState(), drawable, null);
        }

        throw new RuntimeException("Android version 21 is required for setting ripple effect");
    }

    private static ColorStateList getPressedState() {
        return new ColorStateList(new int[][]{new int[]{}}, new int[]{rippleColor});
    }

    public static void initDefaultClickable(int attr) {
        Clickable clickable = Clickable.values()[typedArray.getInt(attr, 1)];

        if (clickable == Clickable.ENABLE) enable();
        else if (clickable == Clickable.DISABLE) disable();
    }

    public static void completeView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.setBackground(getRippleDrawable(shape));
        } else view.setBackground(shape);
    }

    public static void enable() {
        view.setEnabled(true);
        view.setAlpha(1.0F);
    }

    public static void disable() {
        view.setEnabled(false);
        view.setAlpha(0.4F);
    }

    public static void visible() {
        view.setVisibility(View.VISIBLE);
    }

    public static void invisible() {
        view.setVisibility(View.INVISIBLE);
    }

    public static void gone() {
        view.setVisibility(View.GONE);
    }

    public static void onClicked(OnClickListener listener) {
        view.setOnClickListener(listener::onClicked);
    }

    public static void onLongPressed(OnLongPressListener listener) {
        view.setOnLongClickListener(v -> {
            listener.onLongPressed(v);
            return true;
        });
    }
}
