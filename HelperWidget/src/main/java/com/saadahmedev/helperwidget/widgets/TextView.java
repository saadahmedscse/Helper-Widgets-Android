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

package com.saadahmedev.helperwidget.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.saadahmedev.helperwidget.Helper;
import com.saadahmedev.helperwidget.R;
import com.saadahmedev.helperwidget.interfaces.OnLongPressListener;
import com.saadahmedev.helperwidget.utils.ColorUtil;
import com.saadahmedev.helperwidget.utils.Colors;
import com.saadahmedev.helperwidget.utils.FontFamily;

public class TextView extends androidx.appcompat.widget.AppCompatTextView {

    public TextView(@NonNull Context context) {
        super(context);

        init(context, null, 0);
    }

    public TextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs, 0);
    }

    public TextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    @NonNull
    private static int[] cornerRadiusIds() {
        return new int[]{
                R.styleable.TextView_cornerRadius,
                R.styleable.TextView_topLeftCornerRadius,
                R.styleable.TextView_topRightCornerRadius,
                R.styleable.TextView_bottomRightCornerRadius,
                R.styleable.TextView_bottomLeftCornerRadius,
        };
    }

    @NonNull
    private static int[] colorIds() {
        return new int[]{
                R.styleable.TextView_backgroundColor,
                R.styleable.TextView_rippleColor
        };
    }

    @NonNull
    private static int[] strokeIds() {
        return new int[]{
                R.styleable.TextView_strokeWidth,
                R.styleable.TextView_strokeColor
        };
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextView, defStyleAttr, 0);
        Helper.initView(this, context, typedArray, new GradientDrawable());

        Helper.initDefaultColors(colorIds());
        Helper.initDefaultCornerRadius(cornerRadiusIds());
        Helper.initDefaultClickable(R.styleable.TextView_clickable);
        Helper.initDefaultShape(R.styleable.TextView_shape);
        Helper.initDefaultStroke(strokeIds());

        int textColor = typedArray.getColor(R.styleable.TextView_fontColor, ColorUtil.parseColor(Colors.COLOR_DARK_GRAY));
        this.setTextColor(textColor);

        FontFamily fontFamily = FontFamily.values()[typedArray.getInt(R.styleable.TextView_fontFam, 0)];
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontFamily.getValue());
        this.setTypeface(typeface);

        Helper.completeView();
        typedArray.recycle();
    }

    public String getStringValue() {
        return this.getText().toString();
    }

    public String getTrimmedStringValue() {
        return getStringValue().trim();
    }

    public int getIntValue() {
        return Integer.parseInt(getStringValue());
    }

    public double getDoubleValue() {
        return Double.parseDouble(getStringValue());
    }

    public float getFloatValue() {
        return Float.parseFloat(getStringValue());
    }

    public short getShortValue() {
        return Short.parseShort(getStringValue());
    }

    public boolean getBooleanValue() {
        return Boolean.parseBoolean(getStringValue());
    }

    public void enable() {
        Helper.enable();
    }

    public void disable() {
        Helper.disable();
    }

    public void visible() {
        Helper.visible();
    }

    public void invisible() {
        Helper.invisible();
    }

    public void gone() {
        Helper.gone();
    }

    public void onClicked(com.saadahmedev.helperwidget.interfaces.OnClickListener listener) {
        Helper.onClicked(listener);
    }

    public void onLongPressed(OnLongPressListener listener) {
        Helper.onLongPressed(listener);
    }
}
