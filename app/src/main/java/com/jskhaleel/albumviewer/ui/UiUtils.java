package com.jskhaleel.albumviewer.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

import com.afollestad.materialdialogs.MaterialDialog;

public class UiUtils {

    public static Dialog getSpinnerDialog(Context context, String message) {
        Dialog dialog = new MaterialDialog.Builder(context)
                .content(message)
                .progress(true, 0)
                .cancelable(false)
                .build();
        return dialog;
    }

    public static Dialog getProgressDialog(Context context, String message) {
        Dialog dialog = new MaterialDialog.Builder(context)
                .content(message)
                .progress(false, 100)
                .cancelable(false)
                .build();
        return dialog;
    }


    public static Drawable getRectShape(int size, int color) {
        Rect bounds = new Rect(0, 0, size, size);

        ShapeDrawable drawable = new ShapeDrawable();
        int height = bounds.height();
        float out[] = {0f, 0f, height / 2f, height / 2f, height / 2f, height / 2f, 0f, 0f};

        RoundRectShape shape = new RoundRectShape(out, null, null);
        drawable.setBounds(bounds);
        drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        drawable.setShape(shape);
        return drawable;
    }
}
