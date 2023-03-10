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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.saadahmedev.helperwidget.Helper;
import com.saadahmedev.helperwidget.R;
import com.saadahmedev.helperwidget.interfaces.OnLongPressListener;

public class RecyclerView extends androidx.recyclerview.widget.RecyclerView {
    public RecyclerView(@NonNull Context context) {
        super(context);

        init(context, null, 0);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs, 0);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    @NonNull
    private static int[] cornerRadiusIds() {
        return new int[]{
                R.styleable.RecyclerView_cornerRadius,
                R.styleable.RecyclerView_topLeftCornerRadius,
                R.styleable.RecyclerView_topRightCornerRadius,
                R.styleable.RecyclerView_bottomRightCornerRadius,
                R.styleable.RecyclerView_bottomLeftCornerRadius,
        };
    }

    @NonNull
    private static int[] colorIds() {
        return new int[]{
                R.styleable.RecyclerView_backgroundColor,
                R.styleable.RecyclerView_rippleColor
        };
    }

    @NonNull
    private static int[] strokeIds() {
        return new int[]{
                R.styleable.RecyclerView_strokeWidth,
                R.styleable.RecyclerView_strokeColor
        };
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RecyclerView, defStyleAttr, 0);
        Helper.initView(this, context, typedArray, new GradientDrawable());

        Helper.initDefaultColors(colorIds());
        Helper.initDefaultCornerRadius(cornerRadiusIds());
        Helper.initDefaultClickable(R.styleable.RecyclerView_clickable);
        Helper.initDefaultShape(R.styleable.RecyclerView_shape);
        Helper.initDefaultStroke(strokeIds());

        com.saadahmedev.helperwidget.utils.LayoutManager layoutManager = com.saadahmedev.helperwidget.utils.LayoutManager.values()[typedArray.getInt(R.styleable.RecyclerView_setupLayoutManager, 0)];
        if (layoutManager.equals(com.saadahmedev.helperwidget.utils.LayoutManager.STAGGERED_GRID_LAYOUT_MANAGER)) {
            this.setLayoutManager(new StaggeredGridLayoutManager(typedArray.getInteger(R.styleable.RecyclerView_setupLayoutManager, 0), LinearLayoutManager.VERTICAL));
        } else this.setLayoutManager(new LinearLayoutManager(context));

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
