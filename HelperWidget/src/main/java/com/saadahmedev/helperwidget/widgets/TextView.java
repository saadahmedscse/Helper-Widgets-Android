package com.saadahmedev.helperwidget.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.saadahmedev.helperwidget.Helper;
import com.saadahmedev.helperwidget.R;
import com.saadahmedev.helperwidget.utils.Clickable;
import com.saadahmedev.helperwidget.utils.Colors;
import com.saadahmedev.helperwidget.utils.FontStyle;

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

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextView, defStyleAttr, 0);
        Helper.initView(this, typedArray, new GradientDrawable());

        Helper.initDefaultColors(colorIds());
        Helper.initDefaultCornerRadius(cornerRadiusIds());
        Helper.initDefaultClickable(R.styleable.TextView_clickable);

        int textColor = typedArray.getColor(R.styleable.TextView_textColor, parseColor(Colors.COLOR_DARK_GRAY));
        this.setTextColor(textColor);

        FontStyle fontStyle = FontStyle.values()[typedArray.getInt(R.styleable.TextView_fontType, 0)];
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "regular.ttf");
        switch (fontStyle) {
            case BOLD: {
                typeface = Typeface.createFromAsset(context.getAssets(), "bold.ttf");
                break;
            }
            case MEDIUM: {
                typeface = Typeface.createFromAsset(context.getAssets(), "medium.ttf");
                break;
            }
            case REGULAR: {
                typeface = Typeface.createFromAsset(context.getAssets(), "regular.ttf");
                break;
            }
        }
        this.setTypeface(typeface);

        Helper.completeView();
        typedArray.recycle();
    }

    public String getStringValue() {
        return this.getText().toString();
    }

    public String getTrimmedStringValue() {
        return this.getText().toString().trim();
    }

    public int getIntValue() { return Integer.parseInt(this.getStringValue()); }

    public double getDoubleValue() { return Double.parseDouble(this.getStringValue()); }

    public float getFloatValue() { return Float.parseFloat(this.getStringValue()); }

    public short getShortValue() { return Short.parseShort(this.getStringValue()); }

    public boolean getBooleanValue() { return Boolean.parseBoolean(this.getStringValue()); }

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

    private int parseColor(String hex) {
        return Color.parseColor(hex);
    }
}
