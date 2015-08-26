package com.jskhaleel.albumviewer.ui;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;

public class AVTextInputLayout extends TextInputLayout {

    public AVTextInputLayout(Context context) {
        super(context);
    }

    public AVTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setError(CharSequence error) {
        super.setError(error);
        requestFocus();
    }
}
