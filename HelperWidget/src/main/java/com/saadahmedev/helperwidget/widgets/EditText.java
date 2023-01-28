package com.saadahmedev.helperwidget.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Patterns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.saadahmedev.helperwidget.Helper;
import com.saadahmedev.helperwidget.R;
import com.saadahmedev.helperwidget.utils.ColorUtil;
import com.saadahmedev.helperwidget.utils.Colors;
import com.saadahmedev.helperwidget.utils.Countries;
import com.saadahmedev.helperwidget.utils.FontFamily;
import com.saadahmedev.helperwidget.utils.PhoneValidationUtil;

import java.util.Objects;
import java.util.regex.Pattern;

public class EditText extends androidx.appcompat.widget.AppCompatEditText {
    public EditText(@NonNull Context context) {
        super(context);

        init(context, null, 0);
    }

    public EditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs, 0);
    }

    public EditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    @NonNull
    private static int[] cornerRadiusIds() {
        return new int[]{
                R.styleable.EditText_cornerRadius,
                R.styleable.EditText_topLeftCornerRadius,
                R.styleable.EditText_topRightCornerRadius,
                R.styleable.EditText_bottomRightCornerRadius,
                R.styleable.EditText_bottomLeftCornerRadius,
        };
    }

    @NonNull
    private static int[] paddingAndMarginIds() {
        return new int[]{
                R.styleable.EditText_horizontalPadding,
                R.styleable.EditText_verticalPadding,
                R.styleable.EditText_horizontalMargin,
                R.styleable.EditText_verticalMargin
        };
    }

    @NonNull
    private static int[] colorIds() {
        return new int[]{
                R.styleable.EditText_backgroundColor,
                R.styleable.EditText_rippleColor
        };
    }

    @NonNull
    private static int[] strokeIds() {
        return new int[]{
                R.styleable.EditText_strokeWidth,
                R.styleable.EditText_strokeColor
        };
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EditText, defStyleAttr, 0);
        Helper.initView(this, context, typedArray, new GradientDrawable());

        Helper.initDefaultColors(colorIds());
        Helper.initDefaultCornerRadius(cornerRadiusIds());
        Helper.initDefaultClickable(R.styleable.EditText_clickable);
        Helper.initDefaultShape(R.styleable.EditText_shape);
        Helper.initDefaultStroke(strokeIds());
        Helper.initPaddingAndMargin(paddingAndMarginIds());

        int textColor = typedArray.getColor(R.styleable.EditText_fontColor, ColorUtil.parseColor(Colors.COLOR_DARK_GRAY));
        this.setTextColor(textColor);

        FontFamily fontFamily = FontFamily.values()[typedArray.getInt(R.styleable.EditText_fontFam, 0)];
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontFamily.getValue());
        this.setTypeface(typeface);

        Helper.completeView();
        typedArray.recycle();
    }

    public String getStringValue() {
        return Objects.requireNonNull(this.getText()).toString();
    }

    public String getTrimmedStringValue() {
        return getStringValue().trim();
    }

    public int getIntValue() { return Integer.parseInt(getStringValue()); }

    public double getDoubleValue() { return Double.parseDouble(getStringValue()); }

    public float getFloatValue() { return Float.parseFloat(getStringValue()); }

    public short getShortValue() { return Short.parseShort(getStringValue()); }

    public boolean getBooleanValue() { return Boolean.parseBoolean(getStringValue()); }

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

    public boolean isEmpty() {
        return getStringValue().isEmpty();
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public boolean isValidEmail() {
        return Pattern.matches(String.valueOf(Patterns.EMAIL_ADDRESS), getStringValue());
    }

    public boolean isValidPhone(Countries country) {
        PhoneValidationUtil.setPhone(getStringValue());
        return PhoneValidationUtil.isValidPhone(country);
    }
}
