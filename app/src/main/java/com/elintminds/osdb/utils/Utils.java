package com.elintminds.osdb.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.PopupMenu;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.elintminds.osdb.R;

import java.util.concurrent.atomic.AtomicBoolean;

public class Utils {

    public static Drawable setDrawableSelector(Context context, int normal, int selected) {


        Drawable state_normal = ContextCompat.getDrawable(context, normal);

        Drawable state_pressed = ContextCompat.getDrawable(context, selected);


        Bitmap state_normal_bitmap = ((BitmapDrawable) state_normal).getBitmap();

        // Setting alpha directly just didn't work, so we draw a new bitmap!
        Bitmap disabledBitmap = Bitmap.createBitmap(
                state_normal.getIntrinsicWidth(),
                state_normal.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(disabledBitmap);

        Paint paint = new Paint();
        paint.setAlpha(126);
        canvas.drawBitmap(state_normal_bitmap, 0, 0, paint);

        BitmapDrawable state_normal_drawable = new BitmapDrawable(context.getResources(), disabledBitmap);


        StateListDrawable drawable = new StateListDrawable();

        drawable.addState(new int[]{android.R.attr.state_selected},
                state_pressed);
        drawable.addState(new int[]{android.R.attr.state_enabled},
                state_normal_drawable);

        return drawable;
    }

    public static void showHidePass(EditText editText, boolean isShown) {
        if (isShown) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
    }

    public static void justify(final TextView textView) {

        if (textView.getText().toString().trim() != null) {
            if (!textView.getText().toString().trim().equalsIgnoreCase("")) {


                final AtomicBoolean isJustify = new AtomicBoolean(false);

                final String textString = textView.getText().toString();

                final TextPaint textPaint = textView.getPaint();

                final SpannableStringBuilder builder = new SpannableStringBuilder();

                textView.post(new Runnable() {
                    @Override
                    public void run() {

                        if (!isJustify.get()) {

                            final int lineCount = textView.getLineCount();
                            final int textViewWidth = textView.getWidth();

                            for (int i = 0; i < lineCount; i++) {

                                int lineStart = textView.getLayout().getLineStart(i);
                                int lineEnd = textView.getLayout().getLineEnd(i);

                                String lineString = textString.substring(lineStart, lineEnd);

                                if (i == lineCount - 1) {
                                    builder.append(new SpannableString(lineString));
                                    break;
                                }

                                String trimSpaceText = lineString.trim();
                                String removeSpaceText = lineString.replaceAll(" ", "");

                                float removeSpaceWidth = textPaint.measureText(removeSpaceText);
                                float spaceCount = trimSpaceText.length() - removeSpaceText.length();

                                float eachSpaceWidth = (textViewWidth - removeSpaceWidth) / spaceCount;

                                SpannableString spannableString = new SpannableString(lineString);
                                for (int j = 0; j < trimSpaceText.length(); j++) {
                                    char c = trimSpaceText.charAt(j);
                                    if (c == ' ') {
                                        Drawable drawable = new ColorDrawable(0x00ffffff);
                                        drawable.setBounds(0, 0, (int) eachSpaceWidth, 0);
                                        ImageSpan span = new ImageSpan(drawable);
                                        spannableString.setSpan(span, j, j + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                                    }
                                }

                                builder.append(spannableString);
                            }

                            textView.setText(builder);
                            isJustify.set(true);
                        }
                    }
                });
            }
        }
    }

    public static void showReportPopupMenu(Context context, View v) {

        PopupMenu popupMenu = new PopupMenu(context, v);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_report:
                        Log.e("item", "Clicked");
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.inflate(R.menu.report);
        popupMenu.show();
    }

    public static void setVectorForPreLollipop(TextView textView, int resourceId, Context activity, int position) {
        Drawable icon;
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            icon = VectorDrawableCompat.create(activity.getResources(), resourceId,
                    activity.getTheme());
        } else {
            icon = activity.getResources().getDrawable(resourceId, activity.getTheme());
        }
        switch (position) {
            case AppConstants.DRAWABLE_LEFT:
                textView.setCompoundDrawablesWithIntrinsicBounds(icon, null, null,
                        null);
                break;

            case AppConstants.DRAWABLE_RIGHT:
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, icon,
                        null);
                break;

            case AppConstants.DRAWABLE_TOP:
                textView.setCompoundDrawablesWithIntrinsicBounds(null, icon, null,
                        null);
                break;

            case AppConstants.DRAWABLE_BOTTOM:
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null,
                        icon);
                break;
        }
    }
}
