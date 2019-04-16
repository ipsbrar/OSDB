package com.osdb.pro.utils;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

public class CardPaddingItemDecoration extends RecyclerView.ItemDecoration
{
    private int paddingBottom;
    private int paddingTop, paddingLeft, paddingRight;

    public CardPaddingItemDecoration(Context context, float top, float bottom, float left, float right) {
        this.paddingBottom = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottom, context.getResources().getDisplayMetrics());
        this.paddingTop = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top, context.getResources().getDisplayMetrics());
        this.paddingLeft = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, left, context.getResources().getDisplayMetrics());
        this.paddingRight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, right, context.getResources().getDisplayMetrics());
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
