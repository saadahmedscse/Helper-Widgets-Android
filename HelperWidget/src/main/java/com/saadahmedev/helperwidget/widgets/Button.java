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

public class Button extends androidx.appcompat.widget.AppCompatButton {
    public Button(@NonNull Context context) {
        super(context);

        init(context, null, 0);
    }

    public Button(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs, 0);
    }

    public Button(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    @NonNull
    private static int[] cornerRadiusIds() {
        return new int[]{
                R.styleable.Button_cornerRadius,
                R.styleable.Button_topLeftCornerRadius,
                R.styleable.Button_topRightCornerRadius,
                R.styleable.Button_bottomRightCornerRadius,
                R.styleable.Button_bottomLeftCornerRadius,
        };
    }

    @NonNull
    private static int[] colorIds() {
        return new int[]{
                R.styleable.Button_backgroundColor,
                R.styleable.Button_rippleColor
        };
    }

    @NonNull
    private static int[] strokeIds() {
        return new int[]{
                R.styleable.Button_strokeWidth,
                R.styleable.Button_strokeColor
        };
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Button, defStyleAttr, 0);
        Helper.initView(this, context, typedArray, new GradientDrawable());

        Helper.initDefaultColors(colorIds());
        Helper.initDefaultCornerRadius(cornerRadiusIds());
        Helper.initDefaultClickable(R.styleable.Button_clickable);
        Helper.initDefaultShape(R.styleable.Button_shape);
        Helper.initDefaultStroke(strokeIds());

        int textColor = typedArray.getColor(R.styleable.Button_fontColor, ColorUtil.parseColor(Colors.COLOR_DARK_GRAY));
        this.setTextColor(textColor);

        FontFamily fontFamily = FontFamily.values()[typedArray.getInt(R.styleable.Button_fontFam, 0)];
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontFamily.getValue());
        this.setTypeface(typeface);

        Helper.completeView();
        typedArray.recycle();
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
