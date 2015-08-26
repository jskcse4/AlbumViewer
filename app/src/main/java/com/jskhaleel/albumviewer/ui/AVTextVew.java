package com.jskhaleel.albumviewer.ui;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class AVTextVew extends AppCompatTextView {

    public AVTextVew(Context context) {
        this(context, null);
    }

    public AVTextVew(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AVTextVew(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
