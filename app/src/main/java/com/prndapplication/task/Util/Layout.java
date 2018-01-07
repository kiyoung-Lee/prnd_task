package com.prndapplication.task.Util;

import android.content.Context;
import android.util.TypedValue;

import java.text.DecimalFormat;

/**
 * Created by KiyoungLee on 2018-01-07.
 */

public class Layout {

    public static int dpToPixel(Context context, int dp) {
        if (context != null) {
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
        } else
            return 0;
    }

    public static String getFormattedPrice(int price) {
        DecimalFormat df = new DecimalFormat("#,###");
        String formatted_price = df.format(price) + "만원";
        return formatted_price;
    }
}
