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
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.saadahmedev.helperwidget.Helper;
import com.saadahmedev.helperwidget.R;
import com.saadahmedev.helperwidget.interfaces.OnLongPressListener;
import com.saadahmedev.helperwidget.utils.DimenUtil;
import com.saadahmedev.helperwidget.utils.ImageUtil;
import com.saadahmedev.helperwidget.utils.Shape;

public class ImageView extends androidx.appcompat.widget.AppCompatImageView {
    private DimenUtil dimenUtil;

    public ImageView(Context context) {
        super(context);

        init(context, null, 0);
    }

    public ImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs, 0);
    }

    public ImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    @NonNull
    private static int[] cornerRadiusIds() {
        return new int[]{
                R.styleable.ImageView_cornerRadius
        };
    }

    @NonNull
    private static int[] colorIds() {
        return new int[]{
                R.styleable.ImageView_backgroundColor,
                R.styleable.ImageView_rippleColor
        };
    }

    @NonNull
    private static int[] strokeIds() {
        return new int[]{
                R.styleable.ImageView_strokeWidth,
                R.styleable.ImageView_strokeColor
        };
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        dimenUtil = DimenUtil.getInstance(context);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImageView, defStyleAttr, 0);
        Helper.initView(this, context, typedArray, new GradientDrawable());

        Helper.initDefaultColors(colorIds());
        Helper.initDefaultCornerRadius(cornerRadiusIds());
        Helper.initDefaultClickable(R.styleable.ImageView_clickable);
        Helper.initDefaultStroke(strokeIds());
        setImageRounded(dimenUtil.floatToDp(typedArray.getDimension(cornerRadiusIds()[0], 0F)), false);
        initDefaultShape(typedArray);

        Helper.completeView();
        typedArray.recycle();
    }

    private void initDefaultShape(TypedArray typedArray) {
        Shape viewShape = Shape.values()[typedArray.getInt(R.styleable.ImageView_shape, 12)];
        switch (viewShape) {
            case OVAL:
                setImageRounded(0F, true);
                break;
            case RING:
            case NORMAL:
                break;
            default:
                setImageRounded(dimenUtil.floatToDp(dimenUtil.floatToDp(viewShape.getValue())), false);
        }
    }

    private void setImageRounded(float dp, boolean isOval) {
        this.setImageBitmap(ImageUtil.getRoundedCornerBitmap(ImageUtil.getBitmap(this), dp, isOval));
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
